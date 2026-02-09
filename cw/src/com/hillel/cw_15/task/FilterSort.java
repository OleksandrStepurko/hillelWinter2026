package com.hillel.cw_15.task;

/*
## 1) Фільтрація та сортування
**Дано:** `List<String> words = List.of("Stream", "java", "Level", "mid", "MICROservice", "")`
**Завдання:**
- відкинути порожні та коротші ніж 3 символи;
- привести до нижнього регістру;
- відсортувати спочатку за довжиною, потім лексикографічно.
 */

import java.util.Comparator;
import java.util.List;

public class FilterSort {

    public static void main(String[] args) {
        List<String> words = List.of("Stream", "java", "Level", "mid", "MICROservice", "");

        System.out.println(words.stream()
            .filter(w -> w != null && w.length() >= 3)
            .map(String::toLowerCase)
            .sorted(
                Comparator.comparing(String::length)
                    .thenComparing(Comparator.naturalOrder())
            )
            .toList());

    }

}
