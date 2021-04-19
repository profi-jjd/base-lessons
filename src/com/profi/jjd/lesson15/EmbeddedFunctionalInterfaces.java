package com.profi.jjd.lesson15;

import java.util.Comparator;
import java.util.function.*;

public class EmbeddedFunctionalInterfaces {
    public static void main(String[] args) {
        // boolean test(T t);
        // проверка на положительное число
        // проверка на отрицательное число
        // проверка на четное число
        Predicate<Integer> isPos = x -> x > 0;
        Predicate<Integer> isNeg = x -> x < 0;
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isPos.and(isEven).test(8)); // && И
        System.out.println(isNeg.or(isEven).test(8)); // || ИЛИ
        System.out.println(isNeg.negate().test(4)); // ! НЕ

        // R apply(T t);
        Function<Integer, Integer> sqrt = x -> x * x;
        System.out.println(sqrt.apply(3)); // 9
        Function<Integer, String> convert = x -> x + "RUB";
        System.out.println(convert.apply(45)); // "45RUB"

        // BiFunction apply(T t, U u)
        // Consumer void accept(T t);
        // BiConsumer void accept(T t, U u);
        // Comparator int compare(T o1, T o2);
    }
}