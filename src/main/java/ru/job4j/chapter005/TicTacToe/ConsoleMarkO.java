package ru.job4j.chapter005.TicTacToe;

import java.io.OutputStream;

public class ConsoleMarkO implements Mark<OutputStream> {

    private boolean markX = false;

    public boolean isMarkX() {
        return markX;
    }

    @Override
    public void print(OutputStream screen) {

    }
}
