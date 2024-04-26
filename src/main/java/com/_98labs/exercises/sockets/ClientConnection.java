package com._98labs.exercises.sockets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection {
    private static final Logger logger = LogManager.getLogger(ClientConnection.class);

    private final Socket socket;
    private final PrintWriter out;
    private final BufferedReader in;
    private final Scanner userInputScanner;

    public ClientConnection(Socket socket, PrintWriter out, BufferedReader in, Scanner userInputScanner) {
        this.socket = socket;
        this.out = out;
        this.in = in;
        this.userInputScanner = userInputScanner;
    }

    public void start() {
        try {
            String userInput;
            do {
                logger.info("Enter the line number (Enter '00' to exit):");
                userInput = userInputScanner.nextLine();
                if (isValidInput(userInput)) {
                    sendUserInput(userInput);
                    if (!userInput.equals("00")) {
                        String response = receiveResponse();
                        logger.info("Response from server: Line " + userInput + " : " + response);
                    }
                }else {
                    logger.info("Invalid input. Please enter integer number greater than 0.");
                }
            } while (!userInput.equals("00"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            closeResources();
        }
    }
    public boolean isValidInput(String userInput) {
        // Check if userInput is numeric and within a valid range
        try {
            int lineNumber = Integer.parseInt(userInput);
            return lineNumber > 0;
        } catch (NumberFormatException e) {
            return false; // Input is not numeric
        }
    }

    private void sendUserInput(String userInput) throws IOException {
        out.println(userInput);
    }

    private String receiveResponse() throws IOException {
        return in.readLine();
    }

    private void closeResources() {
        try {
            socket.close();
            out.close();
            in.close();
            userInputScanner.close();
        } catch (IOException e) {
            logger.error("Error occurred while closing resources: " + e.getMessage());
        }
    }
}
