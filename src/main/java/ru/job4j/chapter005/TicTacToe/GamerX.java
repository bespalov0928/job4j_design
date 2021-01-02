package ru.job4j.chapter005.TicTacToe;

public class GamerX implements Gamer {
    private boolean markX = true;
    private Mark[][] mark;

    public boolean isMarkX() {
        return markX;
    }

    public Mark[][] getMark() {
        return mark;
    }

    public void setMark(Mark[][] mark) {
        this.mark = mark;
    }
}
