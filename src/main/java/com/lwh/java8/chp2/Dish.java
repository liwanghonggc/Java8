package com.lwh.java8.chp2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;


/**
 * @author lwh
 * @date 2018-11-17
 * @desp
 */
@Data
@AllArgsConstructor
public class Dish {

    private final String name;

    private final boolean vegetarian;

    private final int calories;

    private final Type type;

    public enum Type {
        /**
         * 食物枚举
         */
        MEAT, FISH, OTHER
    }

    public static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

}
