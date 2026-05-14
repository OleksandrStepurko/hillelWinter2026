package com.hillel.cw_39;

import java.util.HashMap;
import java.util.Map;

public class TemplateRun {

    public static void main(String[] args) {
        String template = "{user}  Hello  from {customer}";

        Map<String, String> values = new HashMap<>();
        values.put("user", "Alex");
        values.put("customer", "Mono bank");

        Map<String, String> values1 = new HashMap<>();
        values1.put("user", "Test");
        values1.put("customer", "Test");

        String str = replacePlaceholders(template, values);
        System.out.println(str);
        String str1 = replacePlaceholders(template, values1);
        System.out.println(str1);

        System.out.println(template);



    }

    private static String replacePlaceholders(String template, Map<String, String> values) {
//        String rez = template;
        for (Map.Entry<String, String> entry : values.entrySet()){
            String pls = "{" + entry.getKey() + "}";
            template = template.replace(pls, entry.getValue());
        }
        return template;
    }

}
