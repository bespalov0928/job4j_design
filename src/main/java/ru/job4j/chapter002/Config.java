package ru.job4j.chapter002;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.UnsupportedAddressTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {

        try (BufferedReader in = new BufferedReader(new FileReader((this.path)))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] arr = line.split("=");
                if (arr.length != 2) {
                    continue;
                }
                String key = arr[0];
                String value = arr[1];
                values.put(key, value);

            }
            System.out.println(values);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {

        String value = values.get(key);
        if (value == null) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        } else {
            return value;
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return out.toString();
    }

    public static void main(String[] args) {
        //System.out.println(new Config("app.properties"));
        Config config = new Config("app.properties");
        config.load();
        System.out.println(config.value("hibernate.dialect"));
    }
}

