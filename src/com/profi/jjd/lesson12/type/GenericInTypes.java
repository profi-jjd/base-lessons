package com.profi.jjd.lesson12.type;

public class GenericInTypes {
    public static void main(String[] args) {
        User<String> stringUser = new User<>("wqw12", "qwerty", "123");
        System.out.println(stringUser.getId().length());

        User<Integer> integerUser = new User<>(1, "zzz", "111");
        System.out.println(integerUser.getId().doubleValue());
        // PairContainer<T, K>
        PairContainer<String, Integer> container1 =
                new PairContainer<>("key", 122);
        System.out.println(container1.getKey().compareTo("key1"));
        System.out.println(container1.getValue().byteValue());

        PairContainer<Double, User> container2 =
                new PairContainer<>(12.1, stringUser);
        container2.getValue().setId("123");
        container2.getValue().setId(234);
        container2.getValue().getId(); // id - Object

        PairContainer<Double, User<Integer>> container3 =
                new PairContainer<>(1.1, integerUser);
        container3.getValue().setId(2);
        System.out.println(container3.getValue().getId()); // id - Integer




    }
}
