package com.lwh.java8.chp2.demo1;

import com.lwh.java8.chp2.Dish;

import java.util.*;

import static java.util.stream.Collectors.toList;

/**
 * @author lwh
 * @date 2018-11-17
 * @despn Stream的简洁
 */
public class Demo1Stream {

    /**
     * Java7实现,返回低热量的菜肴名称,并按照卡路里排序
     */
    private static List<String> getDishNamesByJava7(List<Dish> menu) {
        List<Dish> lowCalorieDishes = new ArrayList<>();

        //获取低于400卡路里的
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCalorieDishes.add(d);
            }
        }

        //对低于400卡路里的排序
        Collections.sort(lowCalorieDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCalorieDishNames = new ArrayList<>();
        for (Dish d : lowCalorieDishes) {
            lowCalorieDishNames.add(d.getName());
        }

        return lowCalorieDishNames;
    }

    /**
     * Java8实现,返回低热量的菜肴名称,并按照卡路里排序
     */
    private static List<String> getDishNamesByJava8(List<Dish> menu) {
        List<String> lowCalorieDishNames = menu.stream()
                                               .filter(d -> d.getCalories() < 400)
                                               .sorted(Comparator.comparing(Dish::getCalories))
                                               .map(Dish::getName)
                                               .collect(toList());
        return lowCalorieDishNames;
    }

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        List<String> dishNamesByJava7 = getDishNamesByJava7(menu);
        System.out.println(dishNamesByJava7);

        List<String> dishNamesByJava8 = getDishNamesByJava8(menu);
        System.out.println(dishNamesByJava8);
    }
}
