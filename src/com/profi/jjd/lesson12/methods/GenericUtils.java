package com.profi.jjd.lesson12.methods;

public class GenericUtils {
    // public static boolean inArray(String[] arr, String elem){ }
    // public static boolean inArray(int[] arr, int elem){ }

    public static <T> boolean inArray(T[] arr, T elem) {
        for (T t : arr) {
            if (t.equals(elem)) return true;
        }
        return false;
    }

    public static <T extends Number, K extends Number>
            int compareNumbersHashCode(T first, K second){
        return Integer.compare(first.hashCode(), second.hashCode());
    }
}
