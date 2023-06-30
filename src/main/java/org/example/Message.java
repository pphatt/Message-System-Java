package org.example;

import java.util.Date;

public class Message {
    private String message;
    private String date;

    public Message(String message, String date) {
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }
}
