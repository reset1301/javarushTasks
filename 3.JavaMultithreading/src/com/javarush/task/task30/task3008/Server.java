package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            ConsoleHelper.writeMessage(String.valueOf(socket.getRemoteSocketAddress()));
            try {
                Connection connection = new Connection(this.socket);
                String userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Error.");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> m : connectionMap.entrySet()
                    ) {
                if (!m.getKey().equals(userName))
                    connection.send(new Message(MessageType.USER_ADDED, m.getKey()));
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message message = null;
            boolean b = true;
            while (b) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    b = false;
                    if (!message.getData().equals("") && !connectionMap.containsKey(message.getData())) {
                        connectionMap.put(message.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        b = false;
                    } else b = true;
                }
            }
            return message.getData();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> m : connectionMap.entrySet()
                ) {
            try {
                m.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            try {
                assert serverSocket != null;
                serverSocket.close();
            } catch (IOException ignored) {
            }
        }
    }
}
