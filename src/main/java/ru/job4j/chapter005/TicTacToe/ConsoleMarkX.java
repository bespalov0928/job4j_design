package ru.job4j.chapter005.TicTacToe;

import java.io.OutputStream;

public class ConsoleMarkX implements Mark<OutputStream> {

    private boolean markX = true;

    public boolean isMarkX() {
        return markX;
    }

    @Override
    public void print(OutputStream screen) {

    }
}
