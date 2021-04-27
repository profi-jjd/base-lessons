package com.profi.jjd.lesson19.serialization.socketstream;

import java.time.LocalDateTime;

public class SimpleMessage {
    private String sender;
    private String text;
    private LocalDateTime dateTime;

    public SimpleMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(){
        dateTime = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "SimpleMessage{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static SimpleMessage getMessage(String sender, String text){
        return new SimpleMessage(sender, text);
    }
}