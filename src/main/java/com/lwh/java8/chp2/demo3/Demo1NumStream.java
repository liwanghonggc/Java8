package com.lwh.java8.chp2.demo3;

import com.lwh.java8.chp2.Dish;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 数值流
 */
public class Demo1NumStream {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        //映射到数值流
        int calories = menu.stream().mapToInt(Dish::getCalories).sum();

        //转换为对象流
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> boxedStream = intStream.boxed();

        //默认值optionalInt
        OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
        int maxCal = maxCalories.orElse(1);

        //数值范围,rangeClosed含头含尾,range含头不含尾
        IntStream evenNums = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
        System.out.println(evenNums.count());
    }
}
