package com.made.academy.m1.exception;

public class TradeNotFoundException extends RuntimeException {
    public TradeNotFoundException(Throwable e) {
        super(e);
    }
}
