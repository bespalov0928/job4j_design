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
                        answer = request.equals("Hello") ? "Hello" : str;
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(answer.getBytes());
                        out.flush();
                        if (request.equals("Exit")) {
                            server.close();
                            break;
                        }
                    }
                }
            }
        }
    }


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
