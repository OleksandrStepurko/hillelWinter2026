package com.game.bj.dto;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {

    private BigInteger amount;
    private Currency currency;

    public Amount(BigInteger amount) {
        this.amount = amount;
        this.currency = Currency.POINT;
    }

    public Amount( BigInteger amount, Currency currency) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
