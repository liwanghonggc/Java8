package com.lwh.java8.chp2.demo1;

import com.lwh.java8.chp2.Dish;

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
        List<Dish> menu = Dish.menu;

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
