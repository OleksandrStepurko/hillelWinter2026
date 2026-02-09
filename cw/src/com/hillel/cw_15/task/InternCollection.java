package com.hillel.cw_15.task;

import java.util.List;

/*
## 5) Розплющення вкладених колекцій
**Дано:** `List<List<Integer>> matrix`.
**Завдання:** розплющити у `Stream<Integer>`, видалити дублікати, відсортувати.
 */
public class InternCollection {

    public static void main(String[] args) {
        List<List<Integer>> matrix = List.of(
            List.of(3, 1, 2, 3),
            List.of(4, 2, 5),
            List.of(1, 6, 5)
        );

        System.out.println(matrix.stream()
            .flatMap(List::stream) //List<List<Integer>> → Stream<Integer>
            .distinct()
            .sorted()
            .toList());


        System.out.println(matrix.stream()
            .<Integer> mapMulti(Iterable::forEach)
            .distinct()
            .sorted()
            .toList());

    }

}
