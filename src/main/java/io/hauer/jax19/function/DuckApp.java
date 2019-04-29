package io.hauer.jax19.function;

import java.util.List;
import java.util.function.BiFunction;

import static io.hauer.jax19.function.Food.*;

public class DuckApp {
    private static List<Duck> DUCKS = List.of(new Duck("Gustav"), new Duck("Daisy"), new Duck("Donald"));
    private static Food[] FOOD = new Food[] { Apple, Oat };

    public static void main(String[] args) {

        BiFunction<Duck, Food[], Duck> duckDuckFunction = Duck::eatF;
        DUCKS.stream().map(duck -> duckDuckFunction.apply(duck, FOOD)).forEach(System.out::println);

    }

}
