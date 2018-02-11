package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Введите номер порта:");
        int portNumber = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Сервер запущен");

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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
//            int numTries = 3;
            Message message;
            while(true) { //numTries-- > 0
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                if (message.getType() == MessageType.USER_NAME &&
                        !message.getData().isEmpty() &&
                        !connectionMap.containsKey(message.getData())
                )
                    break;
            }
            connectionMap.put(message.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return message.getData();
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }
    }
}
