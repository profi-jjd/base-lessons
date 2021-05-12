package com.profi.jjd.lesson23;

public class Text extends Message{

    private String text;

    public Text(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
