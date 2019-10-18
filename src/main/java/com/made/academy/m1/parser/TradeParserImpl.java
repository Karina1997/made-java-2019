package com.made.academy.m1.parser;

import com.made.academy.m1.exception.TradeParseException;
import com.made.academy.m1.source.TradeSource;
import com.made.academy.m1.trade.TradeType;
import com.made.academy.m1.trade.Trade;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TradeParserImpl implements TradeParser {

    private static final String TYPE_GRP_NAME = "TYPE";
    private static final String PRICE_GRP_NAME = "PRICE";
    private static final Pattern TRADE_FORMAT_REGEXP =
            Pattern.compile("Trade\\:\\s*\\{[\\r\\n]*\\s*type\\:\\s*(?<TYPE>.*),[\\r\\n]*\\s*price\\:\\s*(?<PRICE>.*)[\\r\\n]*\\}");

    private final TradeSource source;

    public TradeParserImpl(TradeSource source) {
        this.source = source;
    }

    @Override
    public Trade parse() {
        try {
            Matcher m = TRADE_FORMAT_REGEXP.matcher(source.getTrade());
            m.matches();
            TradeType type = resolveTradeType(m.group(TYPE_GRP_NAME));
            BigDecimal price = resolvePrice(m.group(PRICE_GRP_NAME));

            return type.createTrade(price);
        } catch (Exception e) {
            throw new TradeParseException(e);
        }
    }

    private TradeType resolveTradeType(String value) {
        return TradeType.valueOf(value);
    }

    private BigDecimal resolvePrice(String value) {
        return new BigDecimal(value);
    }
}
