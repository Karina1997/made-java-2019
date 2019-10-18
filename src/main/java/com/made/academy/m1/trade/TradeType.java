package com.made.academy.m1.trade;

import java.math.BigDecimal;

public enum TradeType {
    FX_SPOT {
        @Override
        public Trade createTrade(BigDecimal price) {
            return new FxSpotTrade(price);
        }
    },

    BOND {
        @Override
        public Trade createTrade(BigDecimal price) {
            return new BondTrade(price);
        }
    },

    COMMODITY_SPOT {
        @Override
        public Trade createTrade(BigDecimal price) {
            return new CommoditySpotTrade(price);
        }
    },

    IR_SWAP {
        @Override
        public Trade createTrade(BigDecimal price) {
            return new IrSwapTrade(price);
        }
    };

    public abstract Trade createTrade(BigDecimal price);
}
