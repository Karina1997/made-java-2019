package com.made.academy.m1.trade;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class TradeTypeTest {

    @Test
    public void testGetTradeOnTradeTypeFxSpot() {
        Trade trade = TradeType.FX_SPOT.createTrade(BigDecimal.ONE);
        assertTrue(trade instanceof FxSpotTrade);
    }

    @Test
    public void testGetTradeOnTradeTypeBond() {
        Trade trade = TradeType.BOND.createTrade(BigDecimal.ONE);
        assertTrue(trade instanceof BondTrade);
    }

    @Test
    public void testGetTradeOnTradeTypeCommoditySpot() {
        Trade trade = TradeType.COMMODITY_SPOT.createTrade(BigDecimal.ONE);
        assertTrue(trade instanceof CommoditySpotTrade);
    }

    @Test
    public void testGetTradeOnTradeTypeIrSwap() {
        Trade trade = TradeType.IR_SWAP.createTrade(BigDecimal.ONE);
        assertTrue(trade instanceof IrSwapTrade);
    }
}
