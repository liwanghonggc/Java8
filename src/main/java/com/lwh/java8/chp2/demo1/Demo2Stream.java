package com.lwh.java8.chp2.demo1;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * @author lwh
 * @date 2018-11-17
 * @desp 筛选和切片
 */
public class Demo2Stream {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //用谓词筛选
        List<Dish> vegitarianMenu = menu.stream().filter(Dish::isVegetarian).collect(toList());
        System.out.println(vegitarianMenu);

        //筛选各异的元素
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);

        //截断流
        menu.stream().filter(d -> d.getCalories() > 300).limit(3).forEach(System.out::println);

        System.out.println("................................................");

        //跳过元素
        menu.stream().filter(d -> d.getCalories() > 300).skip(2).forEach(System.out::println);

        //筛选前两个荤菜
        menu.stream().filter(d -> d.getType() == Dish.Type.MEAT).limit(2).forEach(System.out::println);

    }
}
