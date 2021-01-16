package ru.job4j.chapter005.TicTacToe;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkO implements Mark<OutputStream> {

    private boolean markX = false;

    @Override
    public boolean isMarkX() {
        return markX;
    }

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("O".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "markO";
    }
}
