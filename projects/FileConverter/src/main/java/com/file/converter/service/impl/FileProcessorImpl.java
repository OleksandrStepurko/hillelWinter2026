package com.file.converter.service.impl;

import com.file.converter.service.FileMapper;
import com.file.converter.service.FileProcessor;
import com.file.converter.service.constans.Extension;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;

public class FileProcessorImpl implements FileProcessor {
    @Override
    public String readFromFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    @Override
    public void writeToFile(String folder, String fileName, String newExtension, String content)
        throws IOException {
        if (!Paths.get(folder).toFile().exists()){
            Paths.get(folder).toFile().mkdir();
        }
        String fileOutput = folder.concat(File.separator).concat(changeExtension(fileName, newExtension));
        Files.writeString(Path.of(fileOutput), content);
    }

    private String changeExtension(String fileName, String newExtension) {
        int dotIndex = fileName.lastIndexOf('.');
        String baseName = (dotIndex == 1) ? fileName : fileName.substring(0, dotIndex);
        return  baseName + "." + newExtension;
    }

    private String getExtension(String fileName) {
        return  fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        Files.delete(Path.of(filePath));
    }

    @Override
    public boolean isProcessedFile(Path filePath) {
        if (Files.exists(filePath) && Files.isRegularFile(filePath)){
            String fileName = filePath.getFileName().toString();
            int extensionIndex = fileName.lastIndexOf('.'); // index before extension stsrt
            String extension = fileName.substring(extensionIndex + 1); // get extension
            return Arrays.stream(Extension.values()).toList().contains(Extension.valueOf(extension.toUpperCase()));
        }
        return false;
    }

    @Override
    public void folderFileChecker(String folderInputPath, String folderOutputPath) throws IOException, InterruptedException {

        WatchService ws = FileSystems.getDefault().newWatchService();
        Path inputFolder = Path.of(folderInputPath);

        inputFolder.register(ws,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE);

        WatchKey key;
        while ((key = ws.take()) != null){
            for (WatchEvent<?> event : key.pollEvents()){
                Path p = (Path) event.context();
                String filePath = folderInputPath.concat(File.separator).concat(p.toString());
                System.out.println(Path.of(filePath));
                if (event.kind().equals( StandardWatchEventKinds.ENTRY_CREATE)){
                    if(isProcessedFile(Path.of(filePath))){
                        System.out.printf("File path: %s", filePath);

                        if ("yaml".equalsIgnoreCase(getExtension(filePath)) || "yml".equalsIgnoreCase(getExtension(filePath))){
                            writeToFile(
                                folderOutputPath,
                                p.toString(),
                                "json",
                                new FileMapperJson().convertFileContent(
                                    readFromFile(filePath)));
                            deleteFile(filePath);
                        } else if ("json".equalsIgnoreCase(getExtension(filePath))) {
                            writeToFile(
                                folderOutputPath,
                                p.toString(),
                                "yaml",
                                new FileMapperYaml().convertFileContent(
                                    readFromFile(filePath)));
                            deleteFile(filePath);
                        }
                    }
                } else if (event.kind().equals( StandardWatchEventKinds.ENTRY_DELETE)){
                    System.out.printf("File deleted: %s", filePath);
                }

            }
            key.reset();
        }


    }
}
