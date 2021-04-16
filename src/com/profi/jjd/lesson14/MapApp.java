package com.profi.jjd.lesson14;

import java.util.HashMap;

public class MapApp {
    public static void main(String[] args) {
        User qwe = new User("qwe", "qwe123", User.Role.USER);
        User asd = new User("asd", "asd123", User.Role.ADMIN);
        User zxc = new User("zxc", "zxc123", User.Role.ADMIN);
        User cvb = new User("cvb", "cvb123", User.Role.USER);

        // HashMap
        HashMap<String, User> userHashMap = new HashMap<>();
    }
}
