package com.made.academy.m1.resolver;

import com.made.academy.m1.trade.Trade;

public interface TradeResolver {
    Trade resolve(String type, String price);
}
