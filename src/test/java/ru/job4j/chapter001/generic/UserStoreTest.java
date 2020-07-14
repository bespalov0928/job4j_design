package ru.job4j.chapter001.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void add() {
//        UserStore list = new UserStore();
//        list.add(new User("123"));
//        list.add(new User("456"));
//        list.add(new User("789"));
//
//        UserStore extend = new UserStore();
//        extend.add(new User("123"));
//        extend.add(new User("456"));
//        extend.add(new User("789"));
//
//        assertThat(extend, is(list));
    }

    @Test
    public void replace() {
//        User user1 = new User("123");
//        User user2 = new User("456");
//        User user3 = new User("789");
//        UserStore list = new UserStore();
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.replace("789", user1);
//
//        UserStore extend = new UserStore();
//        extend.add(user1);
//        extend.add(user2);
//        extend.add(user1);
//
//        assertThat(extend, is(list));
    }

    @Test
    public void delete() {
//        User user1 = new User("123");
//        User user2 = new User("456");
//        User user3 = new User("789");
//        UserStore list = new UserStore();
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.delete("789");
//
//        UserStore extend = new UserStore();
//        extend.add(user1);
//        extend.add(user2);
//
//        assertThat(extend, is(list));
    }

    @Test
    public void findById() {
        User user1 = new User("123");
        User user2 = new User("456");
        User user3 = new User("789");
        UserStore list = new UserStore();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        User result = list.findById("789");

        assertThat(result.getId(), is("789"));
    }
}