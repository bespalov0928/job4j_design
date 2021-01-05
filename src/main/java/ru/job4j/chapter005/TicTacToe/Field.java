package ru.job4j.chapter005.TicTacToe;

import java.io.ByteArrayOutputStream;

public class Field {

    private Mark[][] table;
    private boolean nextGamerX;

//    public Field(Mark[][] table) {
//        this.table = table;
//    }

    public boolean isNextGamerX() {
        return nextGamerX;
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
     */
    public void moveGamer(Gamer gamer) {

    }

    /**
     * добавлем в массив новую фишку
     *
     * @param row
     * @param col
     */
    public void mark(int row, int col) {
        table[row][col] = nextGamerX ? new ConsoleMarkX(): new ConsoleMarkO();
    }
}
