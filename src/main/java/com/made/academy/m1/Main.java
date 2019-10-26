package com.made.academy.m1;

import com.made.academy.m1.parser.TradeParser;
import com.made.academy.m1.parser.TradeParserImpl;
import com.made.academy.m1.resolver.EnumFactoryTradeResolver;
import com.made.academy.m1.resolver.TradeResolver;
import com.made.academy.m1.source.FileTradeSource;
import com.made.academy.m1.source.TradeSource;
import com.made.academy.m1.trade.Trade;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        TradeSource source = new FileTradeSource(Paths.get(args[0]));
        TradeResolver resolver = new EnumFactoryTradeResolver();
        TradeParser parser = new TradeParserImpl(source, resolver);
        Trade trade = parser.parse();

        System.out.println(trade);
    }
}
