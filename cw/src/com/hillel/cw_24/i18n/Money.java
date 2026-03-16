package com.hillel.cw_24.i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class Money {
    public static void main(String[] args) {
        NumberFormat dollarFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat euroFormatter = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        NumberFormat grnFormatter = NumberFormat.getCurrencyInstance(new Locale("ru",
                "UA"));

        double amount = 123000.56;
        System.out.println(dollarFormatter.format(amount));
        System.out.println(euroFormatter.format(amount));
        System.out.println(grnFormatter.format(amount));
    }


}
