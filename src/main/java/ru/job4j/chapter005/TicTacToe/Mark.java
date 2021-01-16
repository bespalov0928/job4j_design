package ru.job4j.chapter005.TicTacToe;

public interface Mark<T> {
    void print(T screen);
    boolean isMarkX();
}


