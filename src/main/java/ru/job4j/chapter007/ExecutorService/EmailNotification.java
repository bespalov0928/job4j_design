package ru.job4j.chapter007.ExecutorService;

import ru.job4j.chapter007.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {

    private static final EmailNotification INSTANSE = new EmailNotification();
    ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static EmailNotification getInstance() {
        return INSTANSE;
    }

    public void emailTo(User user) {

       pool.submit(() -> {
            String subject = String.format("Notification {%s} to email {%s}.", user.getName(), user.getEmail());
            String body = String.format("Add a new event to {%s}", user.getName());
            send(subject, body, user.getName());
        });
    }

    public void close() {
        pool.shutdown();
    }

    public void send(String subject, String body, String email) {

    }
}
