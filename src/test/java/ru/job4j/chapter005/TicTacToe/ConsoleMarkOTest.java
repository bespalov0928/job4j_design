package ru.job4j.chapter005.TicTacToe;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConsoleMarkOTest {

    @Test
    public void print() {
    var out = new ByteArrayOutputStream();
    new ConsoleMarkO().print(out);
    assertThat(out.toString(), is("O"));
    }
}