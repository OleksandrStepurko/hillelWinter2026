package com.game.bj.service;

import com.game.bj.dto.Currency;
import com.game.bj.dto.Player;
import java.math.BigInteger;
import java.util.Scanner;

public class InitGameService {
    public Player initGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name :");
        String name = sc.nextLine();
        System.out.println("Please enter number of games: ");
        int games = sc.nextInt();
        System.out.println("Please put money: ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.println("Please put currency from list [UAH,USD,EUR,GBP,BAH]: ");
        String currency = sc.nextLine();

        ExchangeServise es = new ExchangeServise();
        BigInteger convertAmount = es.toPoint(amount, Currency.valueOf(currency));

        System.out.println("You receive " + convertAmount + " points");

        return new Player(name, convertAmount, games);
    }
}
