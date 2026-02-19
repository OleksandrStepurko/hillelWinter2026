package com.hillel.tests;

import java.io.IOException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class JLineExample {
    public static void main(String[] args) {
        try {
            // Create a terminal
            Terminal terminal = TerminalBuilder.builder().system(true).build();

            // Create a line reader
            LineReader reader = LineReaderBuilder.builder().terminal(terminal).build();

            // Read lines from the user
            while (true) {
                String line = reader.readLine("prompt> ");

                // Exit if requested
                if ("exit".equalsIgnoreCase(line)) {
                    break;
                }

                // Echo the line back to the user
                terminal.writer().println("You entered: " + line);
                terminal.flush();
            }

            terminal.writer().println("Goodbye!");
            terminal.close();

        } catch (IOException e) {
            System.err.println("Error creating terminal: " + e.getMessage());
        }
    }
}
