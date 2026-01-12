package com.hillel.cw_07.task;
/*
### 8. Безпечне обрізання рядка

**Завдання:**

```java
String smartTrim(String input, int maxLength);
```

Обрізати рядок до `maxLength`, не обриваючи слова. Додати "..." у кінець, якщо є обрізання. Приклад:

```
smartTrim("Java is great", 7) → "Java is..."
```
 */

public class SmartTrim {

    public static void main(String[] args) {
        System.out.println(smartTrim("Java is great", 8));
    }

    private static String smartTrim(String input, int maxLength){
        if (input == null || input.isBlank() || maxLength <= 0){
            return "";
        }

        if (input.length() <= maxLength){
            return input;
        }

        String cut = input.substring(0, maxLength);
        int lastSpace = cut.lastIndexOf(" ");

        if (lastSpace == -1){
            return "...";
        }

        return cut.substring(0, lastSpace).concat("...");

    }
}
