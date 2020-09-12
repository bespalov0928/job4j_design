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
        //String request = "";
        try (ServerSocket server = new ServerSocket(9004)) {
//            System.out.println("0" + server.isClosed());
            while (!server.isClosed()) {
                Socket socket = server.accept();
//                System.out.println("1" + socket.isClosed());
                //try (OutputStream out = socket.getOutputStream();
                try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    //map = getMap(server, out);
//                    System.out.println("2" + socket.isClosed());
                    String str = "123";
                    while (!(str = in.readLine()).isEmpty()) {
//                        System.out.println("3" + socket.isClosed());
//                        System.out.println(str);
//                        String[] arrRequest = str.split("=");
//                        for (String s:arrRequest) {
//                            System.out.println(s);
//                        }
//                        System.out.println("4" + socket.isClosed());
//                        String strTmp = arrRequest[1];
//                        Consumer predicate = map.get(strTmp);
//                        if (predicate == null) {
//                            System.out.println("5" + socket.isClosed());
                            System.out.println(str.substring(5));
                            out.write("str:" + str.substring(5) + "\r\n\r\n");
                            out.flush();
                            break;
//                        }
                        //predicate.accept(strTmp);
                        //break;
                    }
                    //out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    //out.write("Hello, dear friend.".getBytes());
//                    out.flush();
               }
            }
        }
    }

    public static Map<String, Consumer<String>> getMap(ServerSocket server, BufferedWriter out) {
        Map<String, Consumer<String>> map = new HashMap<>();
//        map.put("Bye", (String p) -> {
//            try {
//                System.out.println(p + System.lineSeparator());
//                server.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("Exit", (String p) -> {
//            try {
//                System.out.println(p + System.lineSeparator());
//                server.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("Hello", (p) -> {
//            try {
//                System.out.println(p + System.lineSeparator());
//                out.write(String.format("%s\n", p));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("What", (p) -> {
//            try {
//                System.out.println(p + System.lineSeparator());
//                out.write(String.format("%s\n", p));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        map.put("Any", (String p) -> {
//            try {
//                System.out.println(p + System.lineSeparator());
//                out.write(String.format("%s\n", p));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
        return map;
    }
}
