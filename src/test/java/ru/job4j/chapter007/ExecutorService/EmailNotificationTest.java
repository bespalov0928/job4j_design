package ru.job4j.chapter007.ExecutorService;

import org.junit.Test;
import ru.job4j.chapter007.User;

import static org.junit.Assert.*;

public class EmailNotificationTest {

    @Test
    public void emailTo() {
        User user = new User(1, 0, "1@mail.ru");
        EmailNotification emailNotification = new EmailNotification();
        emailNotification.emailTo(user);

    }
}