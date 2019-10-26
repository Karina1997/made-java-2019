package com.made.academy.m1.source;

import com.made.academy.m1.exception.TradeNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileTradeSource implements TradeSource {
    private final Path path;

    public FileTradeSource(Path path) {
        this.path = path;
    }

    @Override
    public String getTrade() {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new TradeNotFoundException(e);
        }
    }
}
