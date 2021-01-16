package ru.job4j.chapter005.TicTacToe;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void checkGameEndTrue() {
    Field field = new Field();
        Gamer gamerX = new GamerAll(GamerAll.Type.X);
        Gamer gamerO = new GamerAll(GamerAll.Type.O);
        field.setcurrentGamer(gamerX);
        field.mark(0,0);
        field.setcurrentGamer(gamerO);
        field.mark(0,2);
        field.setcurrentGamer(gamerX);
        field.mark(1,1);
        field.setcurrentGamer(gamerO);
        field.mark(1,2);
        field.setcurrentGamer(gamerX);
        field.mark(2,2);
        boolean rsl = field.checkGameEnd(Mark::isMarkX);
        assertTrue(rsl);
    }

    @Test
    public void checkGameEndFalse() {
    Field field = new Field();
        Gamer gamerX = new GamerAll(GamerAll.Type.X);
        Gamer gamerO = new GamerAll(GamerAll.Type.O);
        field.setcurrentGamer(gamerX);
        field.mark(0,0);
        field.setcurrentGamer(gamerO);
        field.mark(0,2);
        field.setcurrentGamer(gamerX);
        field.mark(1,1);
        field.setcurrentGamer(gamerO);
        field.mark(1,2);
        boolean rsl = field.checkGameEnd(Mark::isMarkX);
        assertFalse(rsl);
    }

    @Test
    public void markIsFalse() {
        Field field = new Field();
        field.setcurrentGamer(new GamerAll(GamerAll.Type.X));
        field.mark(0,0);
        boolean rsl = field.mark(0,0);
        assertFalse(rsl);
    }

    @Test
    public void markIsTrue() {
        Field field = new Field();
        field.setcurrentGamer(new GamerAll(GamerAll.Type.X));
        field.mark(0,0);
        boolean rsl = field.mark(0,1);
        assertTrue(rsl);
    }


}