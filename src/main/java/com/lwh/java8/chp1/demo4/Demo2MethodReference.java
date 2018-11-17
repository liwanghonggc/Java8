package com.lwh.java8.chp1.demo4;

import com.lwh.java8.chp1.demo1.Apple;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author lwh
 * @date 2018-11-14
 * @desp 方法推导
 */
public class Demo2MethodReference {

    public static void main(String[] args) {

        //例1,类::方法-->方法推导
        Function<String, Integer> f1 = Integer::parseInt;
        System.out.println(f1.apply("123"));

        BiFunction<String, Integer, Character> f2 = String::charAt;
        System.out.println(f2.apply("hello", 1));

        //例2,对象::方法-->方法推导
        String str = "hello";
        Function<Integer, Character> f3 = str::charAt;
        System.out.println(f3.apply(0));

        //例3,构造函数推导
        BiFunction<String, Integer, Apple> appleBiFunction = Apple::new;
        Apple redApple = appleBiFunction.apply("red", 200);
        System.out.println(redApple);

    }
}
