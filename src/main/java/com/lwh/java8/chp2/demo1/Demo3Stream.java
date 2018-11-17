package com.lwh.java8.chp2.demo1;

import com.lwh.java8.chp2.Dish;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author lwh
 * @date 2018-11-17
 * @desp 映射之流的扁平化
 */
public class Demo3Stream {

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

        //提取菜肴的名称
        menu.stream().map(Dish::getName).forEach(System.out::println);

        //提取字符串长度
        List<String> strList = Arrays.asList("Java 8", "Lambda", "Action");
        strList.stream().map(String::length).forEach(System.out::println);

    }
}
