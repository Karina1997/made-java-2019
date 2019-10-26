package com.made.academy.m1.exception;

public class TradeParseException extends RuntimeException {
    public TradeParseException(Exception e) {
        super(e);
    }
    public TradeParseException(String s) {
        super(s);
    }
}
