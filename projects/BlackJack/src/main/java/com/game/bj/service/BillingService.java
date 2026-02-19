package com.game.bj.service;

import com.game.bj.dto.Amount;
import com.game.bj.exception.NotEnoughtMoneyException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class BillingService {
    /*
    100
    1 - bet 25 -> WIN  -> +25 >>> amount = 125
    2 - bet 25 -> LOSE -> -25 >>> amount = 100
    3 - bet 25 -> DRAW -> +0  >>> amount = 100
     */

    public void addAmount(Amount amount, BigInteger bet){
        amount.setAmount(amount.getAmount().add(bet));
    }

    public void substractAmount(Amount amount, BigInteger bet){
        amount.setAmount(amount.getAmount().subtract(bet));
    }

    public BigInteger validateAmount(Amount amount, BigInteger bet){
        Scanner sc = new Scanner(System.in);

        if (amount.getAmount().compareTo(BigInteger.ZERO) <= 0){
            throw new NotEnoughtMoneyException("game over... RIP");
        }
        if (bet.compareTo(amount.getAmount()) > 0){
            try {
                System.out.printf("You can put %s points. Continue [Y/N]%n", amount.getAmount());
                String input = sc.nextLine();
                if (!input.equalsIgnoreCase("y")){
                    System.out.printf("Please put your bat less than %s points %n", amount.getAmount());
                    bet = sc.nextBigInteger();
                    sc.nextLine();
                    validateAmount(amount, bet);
                } else {
                    bet = amount.getAmount();
                }
            } catch (NumberFormatException e){
            }
        }
        return bet;
    }

}
