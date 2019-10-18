package com.made.academy.m1.trade;

import java.math.BigDecimal;

public abstract class Trade {

    private final BigDecimal price;

    public Trade(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "price=" + price +
                '}';
    }
}
