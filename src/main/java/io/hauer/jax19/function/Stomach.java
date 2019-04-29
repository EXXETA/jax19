package io.hauer.jax19.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stomach {
    private final List<Food> content;

    Stomach(){
        this(new ArrayList<>());
    }

    Stomach(List<Food> content, Food... newFood){
        this.content = content;
        content.addAll(Arrays.asList(newFood));
        checkContent(this.content);
    }

    void addFood(Food... food){
        content.addAll(Arrays.asList(food));
        checkContent(this.content);
    }

    List<Food> getContent() {
        return new ArrayList<>(content);
    }

    private static void checkContent(List<Food> food){
        if(food.contains(Food.Bread)){
            throw new RuntimeException("Bad food exception");
        }
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
