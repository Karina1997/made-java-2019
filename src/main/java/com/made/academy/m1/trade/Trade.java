package com.made.academy.m1.trade;

public abstract class Trade {
    private final double price;

    public Trade(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "price=" + price +
                '}';
    }
}
