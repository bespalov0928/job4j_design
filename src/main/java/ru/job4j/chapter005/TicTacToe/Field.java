package ru.job4j.chapter005.TicTacToe;

import java.io.ByteArrayOutputStream;

public class Field {

    private Mark[][] table;
    private boolean nextGamerX;

    public Field(Mark[][] table) {
        this.table = table;
    }

    public boolean isNextGamerX() {
        return nextGamerX;
    }

    public void setNextGamerX(boolean nextGamerX) {
        this.nextGamerX = nextGamerX;
    }

    /**
     * процедура проверки завершения игры
     * нужно будет проверить по вертикали горизонтали и диагонали
     */
    public boolean checkGameEnd() {
        return true;
    }

    /**
     * процедура описывает очередной ход игрока
     * нужно указать следующего игрока по очереди
     * нужно добавить в массив новый элемент фишки
     */
    public void moveGamer(Gamer gamer) {

    }
}
