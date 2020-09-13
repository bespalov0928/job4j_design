package ru.job4j.chapter002.Io.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        Map<String, Consumer<String>> map = new HashMap<>();
        try (ServerSocket server = new ServerSocket(9004)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    map = getMap(server, out);
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        String[] arrFirst = str.split(" ");
//                        for (String s:arrFirst) {
//                            System.out.println(s);
//                        }
                        String strTmp = arrFirst[1];
                        String[] arrSecond = strTmp.split("=");
                        for (String s_ : arrSecond) {
                            System.out.println(s_);
                        }

                        //System.out.println(arrSecond[1]);
                        Consumer predicate = map.get(arrSecond[1]);
                        if (predicate == null) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n");
                            out.write(str + "\r\n\r\n");
                            out.flush();
                            break;
                        }
                        predicate.accept(arrSecond[1]);
                        break;
                    }
                    //out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    //out.write("Hello, dear friend.".getBytes());
                    //out.flush();
                }
            }
        }
    }

    public static Map<String, Consumer<String>> getMap(ServerSocket server, BufferedWriter out) {
        Map<String, Consumer<String>> map = new HashMap<>();
        map.put("Bye", (String p) -> {
            try {
                System.out.println("Bye:" + p + System.lineSeparator());
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        map.put("Exit", (String p) -> {
            try {
                System.out.println("Exit:" + p + System.lineSeparator());
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        map.put("Hello", (p) -> {
            try {
                System.out.println("Hello:" + p + System.lineSeparator());
                out.write("HTTP/1.1 200 OK\r\n\r\n");
                out.write(String.format("%s\n", p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        map.put("What", (p) -> {
            try {
                System.out.println("What:" + p + System.lineSeparator());
                out.write("HTTP/1.1 200 OK\r\n\r\n");
                out.write(String.format("%s\n", p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        map.put("Any", (String p) -> {
            try {
                System.out.println("Any:" + p + System.lineSeparator());
                out.write("HTTP/1.1 200 OK\r\n\r\n");
                out.write(String.format("%s\n", p));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return map;
    }
}
