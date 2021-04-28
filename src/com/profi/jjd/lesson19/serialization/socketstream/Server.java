package com.profi.jjd.lesson19.serialization.socketstream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private Connection connection;

    public Server(int port) {
        this.port = port;
    }

    public void start(){

        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен");
            while (true) {
                Socket newClient = serverSocket.accept();
                connection = new Connection(newClient);
                SimpleMessage message = connection.readMessage();
                System.out.println(message);
                connection.sendMessage(
                        SimpleMessage.getMessage("сервер", "сообщение"));
            }
        } catch (IOException e) {
            System.out.println("Ошибка сервера");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        }
    }

}
