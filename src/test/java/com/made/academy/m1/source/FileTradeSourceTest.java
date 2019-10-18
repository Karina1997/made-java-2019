package com.made.academy.m1.source;

import com.made.academy.m1.exception.TradeNotFoundException;
import org.junit.Test;

import java.nio.file.Path;

public class FileTradeSourceTest {

    @Test(expected = TradeNotFoundException.class)
    public void testGetTradeOnFileNotExist() {
        FileTradeSource source = new FileTradeSource(Path.of(""));
        source.getTrade();
    }
}
