package ru.job4j.chapter003;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.module.FindException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/idea_db";
        Map<String, String> map = readFile();
        String login = map.get("username");
        String password = map.get("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    private static Map<String, String> readFile() {
        Map rsl = new HashMap();
        try (BufferedReader in = new BufferedReader(new FileReader("app.properties"))) {
            String line;
            while ((line = in.readLine()) != null) {

                Integer indexPas = line.lastIndexOf("password");
                Integer indexName = line.lastIndexOf("username");
                if (indexPas > 0) {
                    rsl.put("password", line.substring(line.indexOf("=")));
                } else if (indexName > 0) {
                    rsl.put("username", line.substring(line.indexOf("=")));
                }

//                if (line.lastIndexOf("password") < 0 || line.lastIndexOf("username") < 0) {
//                    continue;
//                }
//
//                String key = line.substring(pasIndex);
//                String[] arr = line.split("=");
//                if (arr.length != 2) {
//                    continue;
//                }
//                key = arr[0];
//                if (key.lastIndexOf("password") > 0) {
//                    rsl.put("password", arr[1]);
//                }
//                if (key.lastIndexOf("username") > 0) {
//                    rsl.put("username", arr[1]);
//                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rsl;
    }
}
