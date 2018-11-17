package com.lwh.java8.chp1.demo3;

import com.lwh.java8.chp1.demo1.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author lwh
 * @date 2018-11-14
 * @desp Consumer介绍
 */
public class Demo2Consumer {

    /**
     * 例1,导包快捷键 Alt Enter,介绍下Alt Enter快捷键的其他用法
     */
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T num : list){
            c.accept(num);
        }
    }

    /**
     * 例2,BiConsumer
     */
    public static void forEachBi(String s, List<Apple> apples, BiConsumer<Apple, String> biConsumer){
        for(Apple a : apples){
            biConsumer.accept(a, s);
        }
    }

    public static void main(String[] args) {
        //例1
        //Lambda是Consumer中accept方法的实现
        forEach(Arrays.asList(1, 3, 2, 4, 5), i -> System.out.print(i + " "));
        System.out.println();

        List<Apple> apples = Arrays.asList(new Apple("red", 140), new Apple("green", 200),
                new Apple("green", 100));
        forEach(apples, apple -> System.out.println(apple));

        //例2
        forEachBi("Hi", apples, (apple, s) -> System.out.println(s + ", my weight is: " + apple.getWeight()));
    }
}
