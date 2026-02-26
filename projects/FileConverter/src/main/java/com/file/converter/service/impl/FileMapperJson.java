package com.file.converter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.converter.service.FileMapper;
import java.util.HashMap;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class FileMapperJson implements FileMapper {

    @SneakyThrows
    @Override
    public String convertFileContent(String content) {
        Yaml yaml = new Yaml(new Constructor(HashMap.class, new LoaderOptions()));
        HashMap map = yaml.load(content);

        return new ObjectMapper()
            .writerWithDefaultPrettyPrinter()
            .writeValueAsString(map);
    }
}
