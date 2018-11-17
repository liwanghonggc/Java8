package com.lwh.java8.chp2.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;


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
}
