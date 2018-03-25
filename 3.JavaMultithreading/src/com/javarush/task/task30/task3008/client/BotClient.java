package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
//            ConsoleHelper.writeMessage(message);
            super.processIncomingMessage(message);
            if (message != null && !message.isEmpty() && message.contains(":")) {
                String[] split = message.split(": ", 2);
                String name = split[0];
                String text = split[1];
                Date time = Calendar.getInstance().getTime();
                switch (text) {
                    case ("дата"):
                        sendTextMessage(getTime(name, "d.MM.YYYY"));
                        break;
                    case ("день"):
                        sendTextMessage(getTime(name, "d"));
                        break;
                    case ("месяц"):
                        sendTextMessage(getTime(name, "MMMM"));
                        break;
                    case ("год"):
                        sendTextMessage(getTime(name, "YYYY"));
                        break;
                    case ("время"):
                        sendTextMessage(getTime(name, "h:mm:ss"));
                        break;
                    case ("час"):
                        sendTextMessage(getTime(name, "H"));
                        break;
                    case ("минуты"):
                        sendTextMessage(getTime(name, "m"));
                        break;
                    case ("секунды"):
                        sendTextMessage(getTime(name, "s"));
                        break;
            }

            }
        }

        private String getTime(String name, String pattern) {
            Date time = Calendar.getInstance().getTime();
            return String.format("Информация для %s: %s", name, new SimpleDateFormat(pattern).format(time));
        }
    }

}
