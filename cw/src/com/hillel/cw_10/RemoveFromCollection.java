package com.hillel.cw_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveFromCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            int j = i;
            list.add(j);
        }
        System.out.println(list);

//        // ❗ ВАЖЛИВО ❗
//        // Видалення елементів по ІНДЕКСУ
//        // Після remove(i) всі елементи зсуваються вліво, а i збільшується
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println("i : " + i + " --> " + list);
//            if (i % 2 == 0) {
//                System.out.println("remove: " + list.get(i));
//                list.remove(i);
//            }
//            System.out.println("i : " + i + " --> " + list);
//            System.out.println("-------->>>>>");
//        }
//
//        System.out.println(list);

//        // ❌ ПОМИЛКА!
//        // enhanced for (for-each) використовує Iterator "під капотом"
//        // Але ми змінюємо колекцію напряму через list.remove()
//        // Це призводить до ConcurrentModificationException
//        for (int a : list) {
//            if (a % 2 == 0) list.remove(a);
//        }

        System.out.println(list);

        Iterator<Integer> iter = list.iterator();

        // ✅ ПРАВИЛЬНИЙ спосіб видалення елементів під час ітерації
        while (iter.hasNext()) {
            Integer a = iter.next();
            System.out.print(a + " ");
            if (a % 2 == 0) iter.remove();
        }
        System.out.println();
        System.out.println(list);
//
//        // ❌ ЩЕ ОДНА ПОМИЛКА!
//        // Ітератор вже дійшов до кінця колекції
//        // Виклик next() без hasNext() призведе до NoSuchElementException
//        while (true){
//            Integer a = iter.next();
//            System.out.print(a + " ");
//        }
    }
}
