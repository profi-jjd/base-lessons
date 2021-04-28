package com.profi.jjd.lesson19.serialization;

import com.profi.jjd.lesson19.serialization.school.Director;
import com.profi.jjd.lesson19.serialization.school.Group;
import com.profi.jjd.lesson19.serialization.school.Pupil;

import java.io.Externalizable;
import java.io.File;
import java.io.Serializable; // интерфейс - маркер


public class SerializationDeserialization {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("Алексей");
        pupil1.setGroup(new Group("Химия"));
        pupil1.learn((int) (Math.random() * 20));

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("Светлана");
        pupil2.setGroup(new Group("Биология"));
        pupil2.learn((int) (Math.random() * 20));

        Director director = new Director(2);
        director.setAge(44);
        director.setName("Семенов Егор Даниилович");

        System.out.println(pupil1);
        System.out.println("pupil2: " + pupil2);
        System.out.println(director);

        BinHandler binHandler = new BinHandler(new File("school.bin"));
        binHandler.writeToFile(pupil1);

        Pupil fromFile = binHandler.readFromFile();
        System.out.println(fromFile);

        binHandler.writeToFile(director);
        Director directorFromFile = binHandler.readFromFile();
        System.out.println(directorFromFile);

    }
}
