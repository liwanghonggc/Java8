package com.lwh.java8.chp2.demo1;

import com.lwh.java8.chp2.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * @author lwh
 * @date 2018-11-17
 * @desp 映射之流的扁平化
 */
public class Demo3Stream {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;
        //提取菜肴的名称
        menu.stream().map(Dish::getName).forEach(System.out::println);

        //提取字符串长度
        List<String> strList = Arrays.asList("Java 8", "Lambda", "Action");
        strList.stream().map(String::length).forEach(System.out::println);

    }
}
