package ru.job4j.chapter002.Io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> value = new HashMap<>();

    public String getValue(String key) {
        return value.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Not specifie key and value.");
        }

        for (String str : args) {
            String[] strTemp = str.split("=");
            if (strTemp.length == 0) {
                throw new IllegalArgumentException("Not specifie key and value.");
            } else if (strTemp.length == 1) {
                throw new IllegalArgumentException("Not specifie value.");
            }
            value.put(strTemp[0].replace("-", ""), strTemp[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);

        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF=8"});
        System.out.println(jvm.getValue("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(jvm.getValue("out"));
    }
}
