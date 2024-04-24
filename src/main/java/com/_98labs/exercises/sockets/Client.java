package com._98labs.exercises.sockets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final Logger logger = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner userInputScanner = new Scanner(System.in)) {

            String userInput;
            do {
                logger.info("Enter the line number (Enter '00' to exit):");
                userInput = userInputScanner.nextLine();
                out.println(userInput);
                if (!userInput.equals("00")) {
                    String response = in.readLine();
                    logger.info("Response from server: ");
                    logger.info("Line " + userInput + " : " + response);
                }
            } while (!userInput.equals("00"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}