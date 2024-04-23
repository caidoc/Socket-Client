package com._98labs.exercises.sockets;

public class Client {
    public static void main(String[] args) {
        final String serverAddress = "localhost";
        final int port = 12345;

        PoemClient client = new PoemClient(serverAddress, port);
        client.sendMessage();
    }
}