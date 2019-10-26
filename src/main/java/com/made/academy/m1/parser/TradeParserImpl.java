package com.made.academy.m1.parser;

import com.made.academy.m1.exception.TradeParseException;
import com.made.academy.m1.resolver.TradeResolver;
import com.made.academy.m1.source.TradeSource;
import com.made.academy.m1.trade.Trade;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeParserImpl implements TradeParser {
    private static final String TYPE_GRP_NAME = "TYPE";
    private static final String PRICE_GRP_NAME = "PRICE";
    private static final Pattern TRADE_FORMAT_REGEXP =
            Pattern.compile("Trade\\:\\s*\\{[\\r\\n]*\\s*type\\:\\s*(?<TYPE>.*),[\\r\\n]*\\s*price\\:\\s*(?<PRICE>.*)[\\r\\n]*\\}");

    private final TradeSource source;
    private final TradeResolver resolver;

    public TradeParserImpl(TradeSource source, TradeResolver resolver) {
        this.source = source;
        this.resolver = resolver;
    }

    @Override
    public Trade parse() {
        try {
            Matcher m = TRADE_FORMAT_REGEXP.matcher(source.getTrade());
            m.matches();
            String type = m.group(TYPE_GRP_NAME);
            String price = m.group(PRICE_GRP_NAME);

            return resolver.resolve(type, price);
        } catch (Exception e) {
            throw new TradeParseException(e);
        }
    }
}
