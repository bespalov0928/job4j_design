package ru.job4j.chapter001;

import java.util.*;

/**
 * 2. Проверить две строчки на идентичность.
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        if (left.length() != right.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            char key = left.charAt(i);
            Integer value = map.get(key);
            value = value == null ? 1 : ++value;
            map.put(left.charAt(i), value);
        }
        for (int i = 0; i < right.length(); i++) {
            char key = right.charAt(i);
            Integer value = map.get(key);
            if (value == null) {
                return false;
            }
            if (value == 1) {
                map.remove(right.charAt(i));
            } else {
                map.put(right.charAt(i), --value);
            }
        }
        return map.isEmpty();
    }
}
