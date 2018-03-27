package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public synchronized void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            this.wait();
            if (clientConnected) {
                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
                while (clientConnected) {
                    String mess = ConsoleHelper.readString();
                    if (mess.equals("exit"))
                        break;
                    if (shouldSendTextFromConsole())
                        sendTextMessage(mess);
                }
            } else {
                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Thread is interrupted.");
        }
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error in input text.");
            clientConnected = false;
        }
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter user name: ");
        return ConsoleHelper.readString();
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter address: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter port: ");
        return ConsoleHelper.readInt();
    }

    public class SocketThread extends Thread {
        public void run() {
            String address = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message = connection.receive();
            if (message.getType() == MessageType.NAME_REQUEST) {
                connection.send(new Message(MessageType.USER_NAME, getUserName()));
            } else if (message.getType() == MessageType.NAME_ACCEPTED) {
                notifyConnectionStatusChanged(true);
            } else {
                throw new IOException("Unexpected MessageType");
            }
            while (message.getType() == MessageType.NAME_REQUEST) {
                message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message = connection.receive();
            while (true) {
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else throw new IOException("Unexpected MessageType");
                message = connection.receive();
            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
