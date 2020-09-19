package ru.job4j.chapter002.Io.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class EchoServer {


    public static void main(String[] args) throws IOException {
        Map<String, String> map = getMapNew();
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        try (ServerSocket server = new ServerSocket(9003)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    answer = str;
                    if (str != null && !str.isEmpty()) {
                        System.out.println(str);
                        String request = parser(str);
                        if (request.equals("Hello")) {
                            answer = "Hello";
                        } else if (request.equals("Any")) {
                            answer = scanner.nextLine();
                        }
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(answer.getBytes());
                        out.flush();
                        if (request.equals("Exit")) {
                            //server.close();
                            break;
                        }
                    }
                }
            }
        }
    }

    public static Map<String, String> getMapNew() {
        Map<String, String> map = new HashMap<>();
        map.put("Exit", "Exit");
        map.put("Hello", "Hello");
        map.put("What", "What");
        map.put("Any", "");
        return map;
    }

//    public static Map<String, Consumer<String>> getMap(ServerSocket server, OutputStream out) {
//        Map<String, Consumer<String>> map = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        map.put("Bye", (String p) -> {
//            try {
//                System.out.println("Bye:" + p + System.lineSeparator());
//                server.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("Exit", (String p) -> {
//            System.out.println("Exit:" + p + System.lineSeparator());
//            try {
//                System.out.println("Exit:" + p + System.lineSeparator());
//                server.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("Hello", (p) -> {
//            try {
//                System.out.println("Hello:" + p + System.lineSeparator());
//                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
//                out.write(String.format("%s\n", p).getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("What", (p) -> {
//            try {
//                System.out.println("What:" + p + System.lineSeparator());
//                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
//                out.write(String.format("%s\n", p).getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("Any", (String p) -> {
//            try {
//                String strTmp = scanner.nextLine();
//                Input input = new Input();
//                //String strTmp = input.askStr();
//                System.out.println(strTmp + " : " + p + System.lineSeparator());
//                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
//                out.write(String.format("%s\n", strTmp).getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        return map;
//    }

    public static String parser(String request) {
        String str = "";
        String[] arrFirst = request.split(" ");
        if (arrFirst.length < 2) {
            return str;
        }
        String strFirst = arrFirst[1];
        //System.out.println("strTmp:" + strFirst);

        String[] arrSecond = strFirst.split("=");
        if (arrSecond.length < 2) {
            return str;
        }
        str = arrSecond[1];

        return str;
    }
}
