package ru.job4j.chapter001;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenAddOneElement() {

        Analize analize = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        List<Analize.User> current = new ArrayList<>();

        previous.add(new Analize.User(123, "name1"));
        previous.add(new Analize.User(456, "name2"));

        current.add(new Analize.User(123, "name1"));
        current.add(new Analize.User(456, "name2"));
        current.add(new Analize.User(789, "name3"));

        Analize.Info info = analize.diff(previous, current);

        int result = info.added;
        int extend = 1;

        assertThat(result, is(extend));
    }

    @Test
    public void whenChangeOneElement() {

        Analize analize = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        List<Analize.User> current = new ArrayList<>();

        previous.add(new Analize.User(123, "name1"));
        previous.add(new Analize.User(456, "name2"));
        previous.add(new Analize.User(789, "name3"));

        current.add(new Analize.User(123, "name1"));
        current.add(new Analize.User(456, "name2"));
        current.add(new Analize.User(789, "name4"));

        Analize.Info info = analize.diff(previous, current);

        int result = info.changed;
        int extend = 1;

        assertThat(result, is(extend));
    }

    @Test
    public void whenDeleteOneElement() {

        Analize analize = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        List<Analize.User> current = new ArrayList<>();

        previous.add(new Analize.User(123, "name1"));
        previous.add(new Analize.User(456, "name2"));
        previous.add(new Analize.User(789, "name3"));

        current.add(new Analize.User(123, "name1"));
        current.add(new Analize.User(456, "name2"));


        Analize.Info info = analize.diff(previous, current);

        int result = info.delete;
        int extend = 1;

        assertThat(result, is(extend));
    }

    @Test
    public void whenNoChangedElement() {

        Analize analize = new Analize();
        List<Analize.User> previous = new ArrayList<>();
        List<Analize.User> current = new ArrayList<>();

        previous.add(new Analize.User(123, "name1"));
        previous.add(new Analize.User(456, "name2"));
        previous.add(new Analize.User(789, "name3"));

        current.add(new Analize.User(123, "name1"));
        current.add(new Analize.User(456, "name2"));
        current.add(new Analize.User(789, "name3"));


        Analize.Info result = analize.diff(previous, current);

        Analize.Info extend = new Analize.Info();
        extend.added = 0;
        extend.changed = 0;
        extend.delete = 0;

        assertThat(result, is(extend));
    }
}