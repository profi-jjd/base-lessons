package com.profi.jjd.lesson14;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapApp {
    public static void main(String[] args) {
        User qwe = new User("qwe", "qwe123", User.Role.USER);
        User asd = new User("asd", "asd123", User.Role.ADMIN);
        User zxc = new User("zxc", "zxc123", User.Role.ADMIN);
        User cvb = new User("cvb", "cvb123", User.Role.USER);

        // HashMap
        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(qwe.getLogin(), qwe);
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(zxc.getLogin(), zxc);
        userHashMap.put(cvb.getLogin(), cvb);

        System.out.println(userHashMap.containsKey("cvb"));
        System.out.println(userHashMap.containsValue(zxc));

        // замена по ключу или по ключу и значению j8
        userHashMap.replace("jnsrj", zxc); // null
        // public V replace(K key, V value)
        userHashMap.replace("zxc", cvb, null); // false
        // public boolean replace(K key, V oldValue, V newValue)

        // получение значения по ключу
        System.out.println(userHashMap.get("zxc")); // User
        System.out.println(userHashMap.get("jnsrj")); // null

        // получение значения j8
        User jnsrj = userHashMap.getOrDefault(
                "jnsrj",
                new User("default", "default", User.Role.USER));
        System.out.println(jnsrj);

        // удаление
        // удаляет пару по ключу, вернет удаленное значение или null
        User removed =  userHashMap.remove("zxc");
        System.out.println(removed);
        // удаляет по ключу и значению, возвращает true/false
        System.out.println(userHashMap.remove("zxc", zxc)); // false

        // перебор мапы
        for (Map.Entry<String, User> entry: userHashMap.entrySet()) {
            // Entry("qwe", qwe)
            // Entry("asd", asd) и тд
            System.out.println(entry.getKey()); // возвращает ключ
            System.out.println(entry.getValue()); // возвращает значение
        }
        // HashMap<String, ArrayList<Integer>>
        // HashMap<String, Map<Integer, ArrayList<Integer>>>

        EnumMap<User.Role, ArrayList<User>> enumMap =
                new EnumMap<>(User.Role.class);
        enumMap.put(User.Role.USER, new ArrayList<>(Arrays.asList(qwe, cvb)));
        enumMap.put(User.Role.ADMIN, new ArrayList<>(Arrays.asList(asd, zxc)));
        System.out.println(enumMap.get(User.Role.USER)); // ArrayList<User>

        User newUser = new User("new", "new123", User.Role.ADMIN);
        enumMap.get(newUser.getRole()).add(newUser);

        //перечисление User.Role.values()[USER, ADMIN]
        //мапа values[ArrayList<User>, ArrayList<User>]
        // values[User.Role.USER.ordinal()]


        TreeMap<String, User> treeMap = new TreeMap<>(userHashMap);
        System.out.println(treeMap);

        // вевести логины пользователей с ролью ADMIN
        System.out.println(treeMap.entrySet()); // пары Set
        System.out.println(treeMap.keySet()); // только ключи Set
        System.out.println(treeMap.values()); // только значения Collection

        for (Map.Entry<String, User> entry : treeMap.entrySet()) {
            if (entry.getValue().getRole() == User.Role.ADMIN) {
                System.out.println(entry.getValue().getLogin());
            }
        }

        // LinkedHashMap
        User strong = new User("strong", "strong123", User.Role.ADMIN);
        WeakReference<User> weak = new WeakReference<>(strong);
        strong = null;

        WeakHashMap<String, User> weakHashMap = new WeakHashMap<>();

        // HashMap
        //1 "qwe", qwe
        //34 "asd", asd
        //1 "tye", tye

        // Entry[("asd", asd)+KeyHashCode,Entry("qwe", qwe)+KeyHashCode+next]
        //                                Entry("tye", tye)+KeyHashCode+next
        //                                Entry("rtt", qqw)+KeyHashCode+next







    }
}
