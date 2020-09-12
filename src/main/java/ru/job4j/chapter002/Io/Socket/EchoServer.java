package ru.job4j.chapter002.Io.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9003)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                //try (OutputStream out = socket.getOutputStream();
                try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        //System.out.println(str.getClass());
                        if (str.contains("Bye")) {
                            System.out.println("Bye");
                            server.close();
                            break;
                        } else if (str.contains("Exit")) {
                            System.out.println("Exit");
                            server.close();
                            break;
                        } else if (str.contains("Hello")) {
                            System.out.println("Hello");
                            out.write("Hello.");
                            out.flush();
                            break;
                        } else if (str.contains("What")) {
                            System.out.println("What");
                            out.write("What.");
                            out.flush();
                            break;
                        } else {
                            System.out.println("Other");
                            out.write(str);
                            out.flush();
                            break;
                        }
                    }
                    //out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    //out.write("Hello, dear friend.".getBytes());
                    //out.flush();
                }
            }
        }
    }
}
