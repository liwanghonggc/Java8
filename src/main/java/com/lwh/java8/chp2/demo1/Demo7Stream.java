package com.lwh.java8.chp2.demo1;


import com.lwh.java8.chp2.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 归约
 */
public class Demo7Stream {

    public static void main(String[] args) {
        //元素求和
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        int sum1 = nums.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum1);

        int sum2 = nums.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        //元素求和无初始值
        Optional<Integer> sum3 = nums.stream().reduce(Integer::sum);
        System.out.println(sum3);

        //求最大值和最小值
        Optional<Integer> max = nums.stream().reduce(Integer::max);
        Optional<Integer> min = nums.stream().reduce((x, y) -> x < y ? x : y);
        System.out.println(max + ", " + min);

        //怎样用map和reduce数一数流中一共有多少个菜
        Optional<Integer> sum4 = Dish.menu.stream().map(d -> 1).reduce(Integer::sum);
        System.out.println(sum4);
    }
}
