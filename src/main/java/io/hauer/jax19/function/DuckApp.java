package io.hauer.jax19.function;

import java.util.List;

import static io.hauer.jax19.function.Duck.eat;
import static io.hauer.jax19.function.Food.*;

public class DuckApp {
    private static List<Duck> DUCKS = List.of(new Duck("Gustav"), new Duck("Daisy"), new Duck("Donald"));
    private static Food[] FOOD = new Food[] { Apple, Oat };

    public static void main(String[] args) {

        System.out.println("FunO:");

        DUCKS.stream().map(duck -> duck.eatF(Apple, Oat)).forEach(System.out::println);

        System.out.println("\nFunktional:");


        for (Duck duck : DUCKS) {
            eat(duck.stomach, Apple, Oat);
            System.out.println(duck);
        }


        for (Duck duck : DUCKS) {
            duck.eat(Apple, Oat);
            System.out.println(duck);
        }


        DUCKS.parallelStream()
            .map(duck ->
                new Duck(duck.name,
                    new Stomach(duck.stomach.getContent(), Apple, Oat)))
            .forEach(System.out::println);


        DUCKS.stream()
            .map(duck -> duck.eatF(Apple, Oat))
            .forEach(System.out::println);

    }

}
