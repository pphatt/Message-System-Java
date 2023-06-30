package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MessageSystem {
    private Queue<Message> MessageBuffer;
    private Stack<Message> MessageStack;

    public MessageSystem() {
        MessageBuffer = new LinkedList<>();
        MessageStack = new Stack<>();
    }

    public void Enqueue(Message message) {
        if (message.getMessage().length() > 250) {
            throw new IllegalArgumentException("Message exceeds 250 characters in length");
        }

        MessageBuffer.add(message);
    }

    public void Sender() {
        if (MessageBuffer.isEmpty()) {
            throw new Error("Message Buffer is empty");
        }

        System.out.println("Sending message to stack...");

        while (!MessageBuffer.isEmpty()) {
            Message message = MessageBuffer.remove();
            MessageStack.add(message);
        }

        System.out.println("Sending message to stack successfully");
    }

    public void Receiver() {
        if (MessageStack.isEmpty()) {
            throw new Error("Message Buffer is empty");
        }

        System.out.println("Processing message from stack...");

        System.out.println("╔" + "═".repeat(2 + 7 + 51) + "═".repeat(2 + 4 + 31) + "╗");
        System.out.println("║" + " ".repeat(2) + "Message" + " ".repeat(50) + "║║" +
                " ".repeat(2) + "Date" + " ".repeat(30) + "║");

        while (!MessageStack.isEmpty()) {
            Message message = MessageStack.pop();

            System.out.println(" " + "═".repeat(59) + "  " + "═".repeat(36) + " ");

            System.out.println("║" + " ".repeat(2) + message.getMessage() +
                    " ".repeat(50 - message.getMessage().length() + 7) + "║║" +
                    " ".repeat(2) + message.getDate() + " ".repeat(30 - message.getDate().length() + 4) + "║");
        }

        System.out.println("╚" + "═".repeat(2 + 7 + 51) + "═".repeat(2 + 4 + 31) + "╝");
    }
}
