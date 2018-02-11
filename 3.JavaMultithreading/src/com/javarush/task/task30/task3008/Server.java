package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Please enter port number:");
        int portNumber = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is started");

            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void sendBroadcastMessage(Message message) {
        for (ConcurrentHashMap.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не было отправлено");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
