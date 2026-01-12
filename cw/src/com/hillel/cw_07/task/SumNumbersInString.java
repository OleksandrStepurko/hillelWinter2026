package com.hillel.cw_07.task;

/*
### 2. Сума чисел у рядку

**Завдання:** Метод повинен знайти всі числа у рядку та повернути їхню суму.

```java
int sumNumbers(String input);
```

Приклад:
```
sumNumbers("abc12de3f100") → 115
```
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumNumbersInString {

    public static void main(String[] args) {
//        System.out.println(sumNumbers("abc12de3f100"));
        System.out.println(sumNumbersRegExp("abc12de3f100"));
    }

    public static int sumNumbers(String input){
        int sum = 0;
        int current = 0;

        for (char ch : input.toCharArray()){
            if (Character.isDigit(ch)){
                current = current * 10 + (ch - '0');
            } else {
                sum += current;
                current = 0 ;
            }

        }

        return sum + current;
    }

    public static int sumNumbersRegExp(String input){
        int sum = 0;
        Matcher matcher = Pattern.compile("\\d+").matcher(input);

        while (matcher.find()){
            sum += Integer.parseInt(matcher.group());
        }

        return sum;
    }

}
