package ru.job4j.chapter005.TicTacToe;

public class Rules {

    /**
     * процедура проверки очередности хода
     * проверяте у класса Field следующего по очереди игрока
     */
    public boolean checkQueueMove(Field field, Gamer gamer) {
        return true;
    }

    /**
     * процедура проверки возможности хода
     * проверяте у класса Field не заполнена ли ячейка для нового хода
     */
    public boolean checkKorrectlyMove(Field field, Gamer gamer) {
        return true;
    }
}
