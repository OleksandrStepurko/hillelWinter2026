package com.hillel.cw_08.converter;
/*
### 9. Конвертація стилю строк
**Завдання:**
```java
String convertNaming(String input, CaseStyle from, CaseStyle to);
```

Підтримка стилів:

- camelCase
- snake_case
- kebab-case

---
 */

public class TextConverter {

    public  String convertNaming(String input, CaseStyle from, CaseStyle to){
        return null;
    }

    private  String[] normalizeText(String string, CaseStyle from){
        // todo: convert input text to array according input style

        return null;
    }

    private String toOutputCase(String[] str, CaseStyle to){
        // todo: convert arr to text according input style
        return null;
    }

    // camelCase
    private  String toCamelCase(String[] str){
        StringBuilder result = new StringBuilder(str[0].toLowerCase());
        for (int i = 1; i < str.length; i++){
            String w = str[i];
            if (!w.isEmpty()){
                result
                    .append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    // snake_case
    private  String toSnakeCase(String[] str){
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result
                .append(s)
                .append(CaseStyle.SNAKE_CASE.delimiter());
        }
        //todo: check last element
        return result.toString();
    }

    // kebab-case
    private  String toKebabCase(String[] str){
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result
                .append(s)
                .append(CaseStyle.KEBAB_CASE.delimiter());
        }
        //todo: check last element
        return result.toString();
    }
}
