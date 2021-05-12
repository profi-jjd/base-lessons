package com.profi.jjd.lesson23;

import com.profi.jjd.lesson23.annotations.Component;

@Component(fileName = "text.txt")
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
