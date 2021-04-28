package com.profi.jjd.lesson19.serialization.school;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Director extends Human implements Externalizable {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(rating);
        out.writeInt(age); // writeUTF(string);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        rating = in.readInt();
        age = in.readInt();
    }
}