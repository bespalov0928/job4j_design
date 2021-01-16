package ru.job4j.chapter005.TicTacToe;

import java.io.ByteArrayOutputStream;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Field {

    private Mark[][] table = new Mark[3][3];
    private Gamer currentGamer;

    public Gamer iscurrentGamer() {
        return currentGamer;
    }

    public void setcurrentGamer(Gamer currentGamer) {
        this.currentGamer = currentGamer;
    }

    /**
     * процедура проверки завершения игры
     * нужно будет проверить по вертикали горизонтали и диагонали
     */
    public boolean checkGameEnd(Predicate<Mark> condition) {
        return this.
                fillBy(condition, 0, 0, 1, 0)
                || this.fillBy(condition, 0, 1, 1, 0)
                || this.fillBy(condition, 0, 2, 1, 0)
                || this.fillBy(condition, 0, 0, 0, 1)
                || this.fillBy(condition, 1, 0, 0, 1)
                || this.fillBy(condition, 2, 0, 0, 1)
                || this.fillBy(condition, 0, 0, 1, 1)
                || this.fillBy(condition, 0, 2, 1, -1);
    }

    public boolean fillBy(Predicate<Mark> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean rsl = true;
        for (int index = 0; index != this.table.length; index++) {
            Mark cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (cell == null || !predicate.test(cell)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    /**
     * добавлем в массив новую фишку
     *
     * @param row
     * @param col
     */
    public boolean mark(int row, int col) {
        boolean rsl = false;
        if (table[row][col] == null) {
            //table[row][col] = currentGamer.isMark() == GamerAll.Type.X ? new ConsoleMarkX() : new ConsoleMarkO();
            table[row][col] = currentGamer.getNewMark();
            rsl = true;
        }
        return rsl;
    }


}
