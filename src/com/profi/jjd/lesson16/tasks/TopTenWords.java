package com.profi.jjd.lesson16.tasks;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 по частоте встречаемости слов

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // "uncover long uncover injected injected"
        // ["uncover", "long", "uncover", "injected", "injected"]

        // Map<String, Long>
        // Entry("uncover" : 2)
        // Entry("long" : 1)
        // Entry("injected" : 2)
        // Set: Entry("uncover" : 2), Entry("long" : 1), Entry("injected" : 2)


        // Entry(key: "uncover", value 2)
        // Entry("injected" : 2)
        // Entry("long" : 1)
        // Map<String, Long>
        // "uncover" : 2

        Map<String, Long> map = Arrays.stream(text.toLowerCase().split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(), // word -> word
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(map);

    }
}
