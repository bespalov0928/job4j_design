package ru.job4j.chapter002;

import java.io.FileOutputStream;

public class MultiplicationTable {
    public static void main(String[] args) {
        int[] arrFirst = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrSecond = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        String rsl = "";
        for (int x : arrFirst) {
            //System.out.println();

            for (int y : arrSecond) {
                rsl = String.format("%s%d * %d = %d\n", rsl, x, y, x * y);
                //System.out.println(rsl);
            }
            rsl = rsl + "\n";
        }
        System.out.println(rsl);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(rsl.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
