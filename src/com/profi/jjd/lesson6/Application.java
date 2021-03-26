package com.profi.jjd.lesson6;

import java.util.UUID;

public class Application {
    public static void main(String[] args) {
        Climber climber1 = new Climber();
        // обращение к свойствам объекта недоступно,
        // тк им установлен private модификатор доступа
        /*climber1.fullName = "";
        climber1.email = "ivan@mail.com";
        climber1.age = 12;
        climber1.uuid = UUID.randomUUID();*/
        // вызов методов
        String name = "Иван Григорьев";
        int age = 34;
        climber1.setFullName(name);
        climber1.setAge(age);
        climber1.setEmail("ivan@mail.com");
        climber1.setUuid();

        Climber climber2 = new Climber();
        // обращение к свойствам объекта недоступно,
        // тк им установлен private модификатор доступа
        /*climber2.fullName = "Е";
        climber2.email = null;
        climber2.age = -900;
        climber2.uuid = UUID.randomUUID();*/
        climber2.setAge(19);
        climber2.setFullName("Елена Михайлова");
        climber2.setEmail("helena@mail.com");
        climber2.setUuid();

        int helenaAge = climber2.getAge();

        System.out.println(helenaAge);
        System.out.println(climber1);
        System.out.println(climber2);

        Mountain everest = new Mountain("Эверест", 8000);
        Mountain elbrus = new Mountain("Эльбрус", 6000);

        Mountain defaultMountain = new Mountain();

        ClimbingGroup climbingGroup = new ClimbingGroup(elbrus, 5);
        climbingGroup.addClimber(climber1);

        System.out.println(everest);
        System.out.println(elbrus);
        System.out.println(defaultMountain);
    }
}
