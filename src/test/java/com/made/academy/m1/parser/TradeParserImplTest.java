package com.made.academy.m1.parser;

import com.made.academy.m1.exception.TradeParseException;
import com.made.academy.m1.source.SimpleTradeSource;
import com.made.academy.m1.source.TradeSource;
import com.made.academy.m1.trade.BondTrade;
import com.made.academy.m1.trade.FxSpotTrade;
import com.made.academy.m1.trade.Trade;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TradeParserImplTest {

    @Test
    public void testParseOnTradeTypeExist() {
        TradeSource source = simpleTradeSourceFor("FX_SPOT", "101.5");
        Trade trade = new TradeParserImpl(source).parse();

        assertTrue(trade instanceof FxSpotTrade);
        assertEquals(BigDecimal.valueOf(101.5), trade.getPrice());
    }

    @Test(expected = TradeParseException.class)
    public void testParseOnTradeTypeEmpty() {
        TradeSource source = simpleTradeSourceFor("", "101.5");
        new TradeParserImpl(source).parse();
    }

    @Test(expected = TradeParseException.class)
    public void testParseOnTradePriceEmpty() {
        TradeSource source = simpleTradeSourceFor("FX_SPOT", "");
        new TradeParserImpl(source).parse();
    }

    @Test
    public void testParseOnTradePriceDecimalDot() {
        TradeSource source = simpleTradeSourceFor("BOND", "10.512");
        Trade trade = new TradeParserImpl(source).parse();

        assertTrue(trade instanceof BondTrade);
        assertEquals(BigDecimal.valueOf(10.512), trade.getPrice());
    }

    @Test(expected = TradeParseException.class)
    public void testParseOnTradePriceDecimalComma() {
        TradeSource source = simpleTradeSourceFor("BOND", "10,512");
        Trade trade = new TradeParserImpl(source).parse();
    }

    private static TradeSource simpleTradeSourceFor(String type, String price) {
        return new SimpleTradeSource(
                "Trade: {\n\n" +
                        "    type: " + type + ",\n\n " +
                        "    price: " + price + "\n" +
                        "}"
        );
    }
}
