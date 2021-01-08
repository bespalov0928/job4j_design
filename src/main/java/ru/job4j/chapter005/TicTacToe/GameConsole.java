package ru.job4j.chapter005.TicTacToe;

import java.util.Scanner;

public class GameConsole implements AppType {
    private Scanner scanner = new Scanner(System.in);
    private boolean run = true;

    @Override
    public void start() {

        while (run) {
            String select = scanner.nextLine();
            boolean selBol = select == "0" ? false : true;
        }
    }

}
