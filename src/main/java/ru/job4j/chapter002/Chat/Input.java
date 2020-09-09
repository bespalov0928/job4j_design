package ru.job4j.chapter002.Chat;

public interface Input {
    String askStr();

    int askInt(String question);

    int askInt(String question, int max);
}
