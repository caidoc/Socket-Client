package com._98labs.exercises.sockets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class ClientTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setupStreams() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Set up an input stream with "1\n00\n" as user input
        inputStream = new ByteArrayInputStream("1\n00\n".getBytes());
        System.setIn(inputStream);
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    void testClientInputOutput() {
        // Redirect stdout for assertion
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        // Run Client main method
        Client.main(new String[]{});

        // Get the output
        String[] lines = baos.toString().split(System.lineSeparator());

        // Assertions
        assertEquals("Enter the line number (Enter '00' to exit):", lines[1]);
        assertEquals("Response from server: ", lines[2]);
        assertEquals("Line 1 : Server Response 1", lines[3]);
        assertEquals("Enter the line number (Enter '00' to exit):", lines[4]);
    }
}