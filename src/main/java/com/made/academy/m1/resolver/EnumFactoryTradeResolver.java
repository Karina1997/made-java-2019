package com.made.academy.m1.resolver;

import com.made.academy.m1.trade.Trade;
import com.made.academy.m1.trade.TradeType;

public class EnumFactoryTradeResolver implements TradeResolver {
    @Override
    public Trade resolve(String type, String price) {
        TradeType tradeType = TradeType.valueOf(type);
        double tradePrice = Double.parseDouble(price);

        return tradeType.createTrade(tradePrice);
    }
}
