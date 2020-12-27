package ru.job4j.chapter005.lsp;

import org.junit.Test;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.WeakHashMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControllQualityTest {

    @Test
    public void shop() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date expaireDate = dateFormat.parse("31.12.2020");
        Date createDate = dateFormat.parse("10.12.2020");
        Potato potato = new Potato("potato", expaireDate, createDate, 100, 20);
        System.out.println(potato.getTerm());

        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        List<Store> list = new ArrayList<>();
        list.add(trash);
        list.add(shop);
        list.add(warehouse);

        ControllQuality controllQuality = new ControllQuality(list);
        controllQuality.selection(potato);

//        Zone zone = controllQuality.selection(potato, 80);
//        System.out.println(zone);
        assertThat("ru.job4j.chapter005.lsp.Shop", is(shop.getClass().getName()));

    }

    @Test
    public void warehouse() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date expaireDate = dateFormat.parse("31.12.2020");
        Date createDate = dateFormat.parse("26.12.2020");
        Potato potato = new Potato("potato", expaireDate, createDate, 100, 0);
        System.out.println(potato.getTerm());

        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        List<Store> list = new ArrayList<>();
        list.add(trash);
        list.add(shop);
        list.add(warehouse);

        ControllQuality controllQuality = new ControllQuality(list);
        controllQuality.selection(potato);
        assertThat("ru.job4j.chapter005.lsp.Warehouse", is(warehouse.getClass().getName()));
    }

    @Test
    public void trash() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date expaireDate = dateFormat.parse("26.12.2020");
        Date createDate = dateFormat.parse("26.12.2020");
        Potato potato = new Potato("potato", expaireDate, createDate, 100, 0);
        System.out.println(potato.getTerm());

        Trash trash = new Trash();
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        List<Store> list = new ArrayList<>();
        list.add(trash);
        list.add(shop);
        list.add(warehouse);

        ControllQuality controllQuality = new ControllQuality(list);
        controllQuality.selection(potato);
        assertThat("ru.job4j.chapter005.lsp.Trash", is(trash.getClass().getName()));
    }
}
