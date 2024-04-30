# Socket-Client
## Overview
The Socket-Client Project is a simple Java socket client implementation that connects to a server and sends/receives messages.

## Features
  - Client-server communication over TCP/IP sockets.
  - Client can send requests to the server to retrieve specific lines from the poem.

## Requirements
  - Java Development Kit (JDK) 8 or higher
  - Intellij IDEA Community Edition 2023 or later (or any other Java IDE).
  - Basic understanding of Java programming.

## Installation
  1. Clone the repository to your local machine:
    `git clone https://github.com/caidoc/ExerciseProject1`
  2. Open the project in Intellij IDEA.
  3. Compile the Java files.

## Usage
### Client
  1. Run the **Client** class to start the client.
     `Client.java`
  2. Enter a line number to request a specific line from the poem. Enter **00** to terminate the connection.

## Configuration
  - Make sure the server is running and accessible at the specified address and port.
  - Modify the **config.properties** file if necessary to change the **port**.

## Reference
  - [A Guide to Java Sockets](https://www.baeldung.com/a-guide-to-java-sockets)
  - [Read an InputStream using the Java Server Socket](https://www.baeldung.com/java-inputstream-server-socket)
  - [How to Read a File in Java](https://www.baeldung.com/reading-file-in-java)
  - [Read and Write User Input in Java](https://www.baeldung.com/java-console-input-output)
     
