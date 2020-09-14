package ru.job4j.chapter002.Io.Socket;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    public String askStr() {
        return scanner.nextLine();
    }
}
