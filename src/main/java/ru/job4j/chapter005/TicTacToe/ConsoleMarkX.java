package ru.job4j.chapter005.TicTacToe;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkX implements Mark<OutputStream> {

    private boolean markX = true;

    @Override
    public boolean isMarkX() {
        return markX;
    }

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("X".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "markX";
    }
}
