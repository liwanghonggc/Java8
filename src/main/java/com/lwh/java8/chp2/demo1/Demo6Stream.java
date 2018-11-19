package com.lwh.java8.chp2.demo1;

import com.lwh.java8.chp2.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 查找和匹配,是看看数据集中的某些元素是否匹配一个给定的属性
 */
public class Demo6Stream {

    public static void main(String[] args) {
        List<Dish> menu = Dish.menu;

        //anyMatch,流中是否有一个元素能匹配给定的谓词,短路操作
        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is somewhat vegetarian friendly");
        }

        //allMatch,检查流中元素是否都能匹配给定的谓词
        boolean isHealthy = menu.stream().allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);

        //noneMatch,确保流中没有任何元素与给定的谓词匹配
        menu.stream().noneMatch(d -> d.getCalories() >= 1000);

        //查找元素
        Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstNum = nums.stream().map(i -> i * i).filter(i -> i % 3 == 0).findFirst();
        System.out.println(firstNum);

    }
}
