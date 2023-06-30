package org.example;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    MessageSystem messageSystem = new MessageSystem();

    public Menu() {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        while (true) {
            System.out.println("╔══════════ Message System ══════════╗");
            System.out.println("║ 1. Send Message                    ║");
            System.out.println("║ 2. Get Messages                    ║");
            System.out.println("║ 3. Quits                           ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("Input option: ");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Send message: ");
                    String message = scanner.nextLine();

                    try {
                        Date date = new Date();
                        Message sendMessage = new Message(message, dateFormat.format(date));
                        messageSystem.Enqueue(sendMessage);
                        System.out.println("Send message successfully");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Something went wrong try again");
                    }

                    break;
                case 2:
                    try {
                        messageSystem.Sender();
                        messageSystem.Receiver();
                    } catch (Error e) {
                        System.out.println("There is no message to view");
                    }

                    scanner.nextLine();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            String readkey = scanner.nextLine();
        }
    }
}
