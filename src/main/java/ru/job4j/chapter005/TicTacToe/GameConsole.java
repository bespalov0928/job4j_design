package ru.job4j.chapter005.TicTacToe;

import java.util.Scanner;

public class GameConsole implements AppType {
    private Scanner scanner = new Scanner(System.in);
    private boolean run = true;

    @Override
    public void start() {
        AppType game = new GameConsole();
        Field field = new Field();
        Gamer gamerX = new GamerAll(GamerAll.Type.X);
        Gamer gamerO = new GamerAll(GamerAll.Type.O);

        field.setcurrentGamer(gamerX);
        while (run) {

            String select = scanner.nextLine();
            String row = select.split(",")[0];
            String col = select.split(",")[1];

            if (!(field.mark(Integer.valueOf(row), Integer.valueOf(col)))) {
                System.out.println("не правильный ход, повторите попытку");
                continue;
            }

            if (field.checkGameEnd(Mark::isMarkX)) {
                System.out.println("Victory " + field.iscurrentGamer());
                run = false;
                continue;
            }

            Gamer nextGamer = field.iscurrentGamer().isMark() == GamerAll.Type.X ? gamerO : gamerX;
            field.setcurrentGamer(nextGamer);
            System.out.println("next: " + field.iscurrentGamer().toString());
        }
    }

    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole();
        gameConsole.start();
    }

}
