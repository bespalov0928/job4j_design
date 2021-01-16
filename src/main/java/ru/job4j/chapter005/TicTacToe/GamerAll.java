package ru.job4j.chapter005.TicTacToe;

public class GamerAll implements Gamer {
    enum Type {O, X}

    ;

    private Type typeGamer;

    public GamerAll(Type typeGamer) {
        this.typeGamer = typeGamer;
    }

    @Override
    public Type isMark() {
        return typeGamer;
    }

    @Override
    public String toString() {
        return "Gamer{" + typeGamer + '}';
    }

    @Override
    public Mark getNewMark() {
        return typeGamer == Type.X ? new ConsoleMarkX() : new ConsoleMarkO();
    }
//    @Override
//    public  String getName(Gamer gamer) {
//        return "Gamer{" + typeGamer + '}';
//    }

}
