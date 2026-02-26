package com.file.converter.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.converter.service.FileMapper;
import com.file.converter.service.FileProcessor;
import java.util.HashMap;
import lombok.SneakyThrows;
import org.yaml.snakeyaml.Yaml;

public class FileMapperYaml implements FileMapper {

    @SneakyThrows
    @Override
    public String convertFileContent(String content) { // json --> yaml
        ObjectMapper om = new ObjectMapper();
        HashMap map = om.readValue(content, HashMap.class); // need try {} catch () -> log
        Yaml yaml = new Yaml();
        return yaml.dumpAsMap(map);
    }
}
