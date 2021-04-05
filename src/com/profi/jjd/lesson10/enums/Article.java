package com.profi.jjd.lesson10.enums;

import java.time.LocalDateTime;

// java.lang.Enum
public class Article {
    private final String title;
    private String text;
    private final LocalDateTime created;
    private Country country;

    public Article(String title) {
        this.title = title;
        created = LocalDateTime.now();
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public enum Country { //extends java.lang.Enum
        AUSTRALIA, UK, USA
    }
}
