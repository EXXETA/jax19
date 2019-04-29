package io.hauer.jax19.function;

import java.util.List;
import java.util.function.Function;

import static io.hauer.jax19.function.Food.*;

public class DuckApp {
    private static List<Duck> DUCKS = List.of(new Duck("Gustav"), new Duck("Daisy"), new Duck("Donald"));
    private static Food[] FOOD = new Food[] { Apple, Oat };

    public static void main(String[] args) {

        Function<Food[], Function<Duck, Duck>> duckDuckFunction = food -> duck -> duck.eatF(food);
        DUCKS.stream().map(duckDuckFunction.apply(FOOD)).forEach(System.out::println);

    }

}
