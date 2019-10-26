package com.made.academy.m1.source;

public class SimpleTradeSource implements TradeSource {
    private final String trade;

    public SimpleTradeSource(String trade) {
        this.trade = trade;
    }

    @Override
    public String getTrade() {
        return trade;
    }
}
