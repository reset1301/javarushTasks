package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (message != null && message.contains(": ")) {
                String[] mess = message.split(": ");
                switch (mess[1]) {
                    case "дата":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("d.MM.YYYY").format(Calendar.getInstance().getTime()));
                        break;
                    case "день":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("d").format(Calendar.getInstance().getTime()));
                        break;
                    case "месяц":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("MMMM").format(Calendar.getInstance().getTime()));
                        break;
                    case "год":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime()));
                        break;
                    case "время":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("H:mm:ss").format(Calendar.getInstance().getTime()));
                        break;
                    case "час":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("H").format(Calendar.getInstance().getTime()));
                        break;
                    case "минуты":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("m").format(Calendar.getInstance().getTime()));
                        break;
                    case "секунды":
                        sendTextMessage("Информация для " + mess[0] + ": " +
                                new SimpleDateFormat("s").format(Calendar.getInstance().getTime()));
                }
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(String.format("date_bot_%02d", (int) (Math.random() * 99)));
//        }
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
