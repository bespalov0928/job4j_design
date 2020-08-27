package ru.job4j.chapter001;

import java.util.*;

/**
 * 2. Проверить две строчки на идентичность.
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arrLeft = left.toCharArray();
        char[] arrRight = right.toCharArray();
        for (Character chL : arrLeft) {
            Integer value = map.get(chL);
            value = value == null ? 1 : ++value;
            map.put(chL, value);
        }
        for (Character chR : arrRight) {
            Integer value = map.get(chR);
            if (value == null) {
                continue;
            }
            if (value == 1) {
                map.remove(chR);
            } else {
                map.put(chR, --value);
            }
        }
        return map.isEmpty();
    }
}
