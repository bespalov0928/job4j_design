package ru.job4j.chapter001;

import java.util.*;

/**
 * 2. Проверить две строчки на идентичность.
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = false;

        char[] arrLeft = left.toCharArray();
        char[] arrRight = right.toCharArray();

        Arrays.sort(arrLeft);
        Arrays.sort(arrRight);
        if (Arrays.equals(arrLeft, arrRight)) {
            rsl = true;
        }

        return rsl;
    }
}
