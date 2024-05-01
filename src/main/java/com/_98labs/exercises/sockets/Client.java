package com._98labs.exercises.sockets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
public class Client {
    private static final Logger logger = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        String serverAddress = "localhost";
        Properties properties;
        try (InputStream inputStream = Client.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Error loading properties file: {}", e.getMessage());
            return;
        }
        int port = Integer.parseInt(properties.getProperty("port"));

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner userInputScanner = new Scanner(System.in)) {

            ClientConnection clientConnection = new ClientConnection(socket, out, in, userInputScanner);
            clientConnection.start();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
