package io.hauer.jax19.function;

import io.vavr.control.Try;

public class Duck {
    final String name;
    final Stomach stomach;

    Duck(String name) {
        this(name, new Stomach());
    }

    Duck(final String name, final Stomach stomach) {
        this.name = name;
        this.stomach = stomach;
    }

    void eat(Food... food) {
        stomach.addFood(food);
    }

    Try<Duck> eatF(Food... food) {
        return Try.of(() -> new Duck(name, new Stomach(stomach.getContent(), food)));
    }

    @Override public String toString() {
        return "Duck{" + "name='" + name + '\'' + ", stomach=" + stomach + '}';
    }

    static void eat(Stomach stomach, Food... food){
        stomach.addFood(food);
    }
}

