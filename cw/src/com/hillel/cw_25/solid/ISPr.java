package com.hillel.cw_25.solid;

public class ISPr {

}

// Принцип розділення інтерфейсів: Краще мати кілька вузькоспеціалізованих інтерфейсів,
// ніж один загальний інтерфейс, який змушує реалізовувати непотрібні методи.

interface Printer {
    void printDocument();
}

interface Scanner {
    void scanDocument();
}

interface emailSend{
    void sendEmail();
}

// Клас реалізує тільки потрібні методи з окремих інтерфейсів
class MultiFunctionPrinter implements Printer, Scanner, emailSend {
    @Override
    public void printDocument() {
        System.out.println("Друк документа...");
    }

    @Override
    public void scanDocument() {
        System.out.println("Сканування документа...");
    }

    @Override
    public void sendEmail() {
        System.out.println("Відправка документа чеерез емейл...");
    }
}

// Пояснення:
// Ми використовуємо два окремі інтерфейси для друку та сканування,
// замість одного великого інтерфейсу, який міг би змусити нас реалізовувати непотрібні методи.
