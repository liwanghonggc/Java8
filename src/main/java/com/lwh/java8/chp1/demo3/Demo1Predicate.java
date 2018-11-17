package com.lwh.java8.chp1.demo3;

import com.lwh.java8.chp1.demo1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp Predicate介绍,该包下面还有IntPredicate、LongPredicate和BiPredicate(两个参数)
 */
public class Demo1Predicate {

    /**
     * 例1
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> res = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                res.add(t);
            }
        }

        return res;
    }

    /**
     * 例2
     */
    public static List<Apple> filterInt(List<Apple> apples, IntPredicate p){
        List<Apple> res = new ArrayList<>();

        for(Apple apple : apples){
            if(p.test(apple.getWeight())){
                res.add(apple);
            }
        }

        return res;
    }

    /**
     * 例3
     */
    public static List<Apple> filterBiPredicate(List<Apple> apples, BiPredicate<String, Integer> p){
        List<Apple> res = new ArrayList<>();

        for(Apple apple : apples){
            if(p.test(apple.getColor(), apple.getWeight())){
                res.add(apple);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple("red", 140), new Apple("green", 200),
                new Apple("green", 100));

        List<Apple> appleRes = filter(apples, (apple -> "green".equals(apple.getColor())));
        System.out.println(appleRes);

        //不能传null字符串
        List<String> strList = Arrays.asList("abc", "hh", "", "");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> strRes = filter(strList, nonEmptyStringPredicate);
        System.out.println(strRes);

        //IntPredicate测试
        List<Apple> applesInt = filterInt(apples, w -> w > 100);
        System.out.println(applesInt);

        //BiPredicate测试
        List<Apple> applesBiPre = filterBiPredicate(apples, (c, w) -> "green".equals(c) && w > 150);
        System.out.println(applesBiPre);
    }
}
