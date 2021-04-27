package com.profi.jjd.lesson19.serialization.school;


public class Director extends Human {
    private int rating;

    public Director() { }

    public Director(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Director{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}