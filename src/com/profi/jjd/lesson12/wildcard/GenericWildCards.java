package com.profi.jjd.lesson12.wildcard;

import com.profi.jjd.lesson12.type.PairContainer;

public class GenericWildCards {
    public static void main(String[] args) {
        Animal animal = new Cat();
        Cat cat = new Cat();
        Dog dog = new Dog();

        PairContainer<Integer, Animal> animalBox =
                new PairContainer<>(1, animal);

        PairContainer<Integer, Cat> catBox =
                new PairContainer<>(1, cat);

        PairContainer<Integer, Dog> dogBox =
                new PairContainer<>(1, dog);

        GenericWildCards.<Animal>copyValue(catBox, animalBox);
        GenericWildCards.copyValue(animalBox, animalBox);
        GenericWildCards.<Animal>copyValue(dogBox, animalBox);

        // com.profi.jjd.lesson12.wildcard.Cat, java.lang.Object
        // copyValue(animalBox, catBox);
    }
    // ? extends T - передаваемый тип - T или его потомки
    // ? super T - передаваемый тип - T или его предки
    public static <T> void copyValue(
          PairContainer<Integer, ? extends T> from,
          PairContainer<Integer, ? super T> to
    ) {
        to.setValue(from.getValue());
    }
}
