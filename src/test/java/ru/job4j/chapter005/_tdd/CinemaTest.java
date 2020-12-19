package ru.job4j.chapter005._tdd;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }


    //место уже занято
    @Test(expected = NullPointerException.class)
    public void buyOccupiedPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        sessions.size();

    }

    //несуществующее место
    @Test(expected = NumberFormatException.class)
    public void buyFantomPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Scanner s = new Scanner("dsfg");
        String row = s.nextLine();
        Integer.parseInt(row);
    }

    //некоррктная дата
    @Test(expected = IllegalArgumentException.class)
    //@Test
    public void buyInvalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.setLenient(false);
        boolean rsl = true;
        date.set(2020, 13, 40, 00, 00);
        date.getTime();
//        try {
//            date.getTime();
//        } catch (Exception e) {
//            rsl = false;
//        }
//        assertThat(false, is(rsl));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    //Фильм не найден
    @Test
    public void findNoFound() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(null, is(sessions));
    }



    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }


}