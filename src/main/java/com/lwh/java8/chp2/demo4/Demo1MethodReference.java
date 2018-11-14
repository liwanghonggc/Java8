package com.lwh.java8.chp2.demo4;

import java.util.function.Consumer;

/**
 * @author lwh
 * @date 2018-11-14
 * @desp 方法推导
 */
public class Demo1MethodReference {

    public static <T> void accept(T t, Consumer<T> consumer){
        consumer.accept(t);
    }

    public static void main(String[] args) {

        //几种写法,前面两种idea有提示
        Consumer<String> consumer = s -> System.out.println(s);
        accept("lwh", consumer);

        accept("lwh", s -> System.out.println(s));

        accept("lwh", System.out::println);
    }
}
