package com._98labs.exercises.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PoemClient {
    public String serverAddress;
    public int port;
    private final Logger logger = LogManager.getLogger(PoemClient.class);
    public PoemClient(String serverAddress, int port){
        this.serverAddress = serverAddress;
        this.port = port;
    }
    public void sendMessage()  {
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
            throw new RuntimeException(e);
        }
    }
}
