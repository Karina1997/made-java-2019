package com.made.academy.m1.resolver;

import com.made.academy.m1.trade.*;
import com.made.academy.m1.exception.TradeParseException;

public class IfElseTradeResolver implements TradeResolver {
    @Override
    public Trade resolve(String type, String price) {
        double tradePrice = Double.parseDouble(price);
        if ("FX_SPOT".equals(type)) {
            return new FxSpotTrade(tradePrice);
        } else if ("BOND".equals(type)) {
            return new BondTrade(tradePrice);
        } else if ("COMMODITY_SPOT".equals(type)) {
            return new CommoditySpotTrade(tradePrice);
        } else if ("IR_SWAP".equals(type)) {
            return new IrSwapTrade(tradePrice);
        } else {
            throw new TradeParseException("Unknown trade type");
        }
    }
}
