package ru.job4j.chapter005.TicTacToe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleMarkXTest {

    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkX().print(out);
        assertThat(out.toString(), is("X"));
    }
}