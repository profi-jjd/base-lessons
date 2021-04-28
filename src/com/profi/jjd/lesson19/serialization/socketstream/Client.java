package com.profi.jjd.lesson19.serialization.socketstream;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;


    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Введите имя");
        String userName = scanner.nextLine();
        String text;
        while (true) {
            System.out.println("Введите сообщение");
            text = scanner.nextLine();
            if ("exit".equals(text)) break;
            sendAndPrintMessage(SimpleMessage.getMessage(userName, text));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message){
        try (Connection connection = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);

            SimpleMessage fromServer = connection.readMessage();
            System.out.println("от сервера: " + fromServer);
        } catch (IOException e) {
            System.out.println("Ошиба отправики - получения сообщения");
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка чтения сообщения");
        } catch (Exception e) {
            System.out.println("Ошибка соединения");
        }
    }
}
