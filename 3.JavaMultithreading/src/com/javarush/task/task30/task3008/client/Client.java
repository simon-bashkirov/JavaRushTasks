package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

import static com.javarush.task.task30.task3008.MessageType.*;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Возникло исключения во время ожидания соединения с сервером");
                return;
            }
        }

        if (clientConnected)
            System.out.println("Соединение установлено. Для выхода наберите команду 'exit'.");
        else {
            System.out.println("Произошла ошибка во время работы клиента.");
            return;
        }
         
        String text;
        while (clientConnected && !(text = ConsoleHelper.readString()).equals("exit")) {
            if (shouldSendTextFromConsole())
                sendTextMessage(text);
        }

    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите номер порта сервера:");
        return  ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            Message message = new Message(TEXT, text);
            connection.send(message);
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage("Произошла ошибка при отправке сообщения");
        }
    }

    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("[" + userName + "] присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("[" + userName + "] покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        protected void  clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == NAME_REQUEST)
                    connection.send(new Message(USER_NAME, getUserName()));
                else if (message.getType() == NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                }
                else
                    throw new IOException("Unexpected MessageType");
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == TEXT)
                    processIncomingMessage(message.getData());
                else if (message.getType() == USER_ADDED)
                    informAboutAddingNewUser(message.getData());
                else if (message.getType() == USER_REMOVED)
                    informAboutDeletingNewUser(message.getData());
                else
                    throw new IOException("Unexpected MessageType");
            }
        }

    }

}
