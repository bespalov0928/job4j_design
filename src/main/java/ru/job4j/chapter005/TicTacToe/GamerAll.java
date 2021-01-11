package ru.job4j.chapter005.TicTacToe;

public class GamerAll implements Gamer {
    enum Type {O, X};

    private Type typeGamer;

    public GamerAll(Type typeGamer) {
        this.typeGamer = typeGamer;
    }

    public Type isMarkX() {
        return typeGamer;
    }

}
