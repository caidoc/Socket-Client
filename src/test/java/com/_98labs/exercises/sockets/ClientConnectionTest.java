package com._98labs.exercises.sockets;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ClientConnectionTest {

    @Test
    public void testValidInput() {
        ClientConnection client = new ClientConnection(null, null , null, null);
        assertTrue(client.isValidInput("5")); // Valid input
    }

    @Test
    public void testInvalidInput_NonNumeric() {
        ClientConnection client = new ClientConnection(null, null , null, null);
        assertFalse(client.isValidInput("abc")); // Non-numeric input
        assertFalse(client.isValidInput("./...")); // Out of range input
    }

    @Test
    public void testInvalidInput_OutOfRange() {
        ClientConnection client = new ClientConnection(null, null , null, null);
        assertFalse(client.isValidInput("-1")); // Negative input
    }
    @Test
    public void testInvalidInput_NullInput() {
        ClientConnection client = new ClientConnection(null, null, null, null);
        assertFalse(client.isValidInput(null)); // null input
    }
}