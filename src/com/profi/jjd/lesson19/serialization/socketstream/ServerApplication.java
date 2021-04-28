package com.profi.jjd.lesson19.serialization.socketstream;

public class ServerApplication {
    public static void main(String[] args) {
        new Server(8999).start();
    }
}
