package ru.job4j.chapter004.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class ReadFile<K> implements Load {

    @Override
    public K loadDate(Object path) {
        ArrayList<String> lines = new ArrayList<>();
        path = "C:\\projects\\job4j_design\\src\\main\\java\\ru\\job4j\\chapter004\\" + path;
        try (BufferedReader in = new BufferedReader(new FileReader((String) path))) {
            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
                lines.add(line + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (K) lines;
    }

}
