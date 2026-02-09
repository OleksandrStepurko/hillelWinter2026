package com.hillel.cw_15.task;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChangeWordPlace {
    //5. В каждом предложении текста поменять местами первое слово с последним, не изменяя
    //длины предложения.

    private static String EX = "1 2 3 4. 2 3 4. 3 4 5. 6 7. 1";
    private static String REZ = "4 2 3 1. 4 3 2. 5 4 3. 7 6. 1";

    public static void main(String[] args) {

        System.out.println(EX);

        System.out.println(Arrays.stream(EX.split("\\."))
            .map(ChangeWordPlace::rotateElements)
            .collect(Collectors.joining(" ")));


    }

    public static String rotateElements(String input){
        return Stream.concat(
            Arrays.stream(input.trim().split("\\s+")).skip(1),
            Arrays.stream(input.trim().split("\\s+")).limit(1)
        ).collect(Collectors.joining(" ", "", "."));

    }


}
