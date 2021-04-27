package com.profi.jjd.lesson19.serialization.school;


public class Group {
    private String title;

    public Group(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Group{" +
                "title='" + title + '\'' +
                '}';
    }
}