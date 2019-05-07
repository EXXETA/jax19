package io.hauer.jax19.function;

import java.util.List;
import java.util.Random;

import static io.hauer.jax19.function.Food.*;

public class DuckApp {
    private static List<Duck> DUCKS = List.of(new Duck("Gustav"), new Duck("Daisy"), new Duck("Donald"));
    private static Food[] FOOD = {Bread, Oat, Apple};
    private static Random random = new Random();

    public static void main(String[] args) {
        DUCKS.stream()
            .map(duck -> duck.eatF(getFood()).onFailure(exp -> System.out.println(exp.getLocalizedMessage())).recoverWith(exp -> duck.eatF(getFood())))
            .forEach(System.out::println);
    }

    private static Food getFood(){
        return FOOD[random.nextInt(3)];
    }

}
