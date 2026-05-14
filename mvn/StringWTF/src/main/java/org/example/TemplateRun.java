package org.example;

import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

public class TemplateRun {
    public static void main(String[] args) {

        String template =
            "${username} hello from ${username2} how are you";

        Map<String, String> values = Map.of(
            "username", "Alex",
            "username2", "John"
        );

        StringSubstitutor sub = new StringSubstitutor(values);
        String result = sub.replace(template);
        System.out.println(result);
    }
}
