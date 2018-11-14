package com.lwh.java8.chp2.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * @author lwh
 * @date 2018-11-14
 * @desp Function的Demo,Function<T,R>接口定义了一个叫作apply的方法,介绍一个泛型的对象,返回一个泛型R对象
 *       可以定义一个Lambda,将输入对象的信息映射到输出
 */
public class Demo3Function {

    public static <T, R> List<R> map(List<T> list, Function<T, R> f){
        List<R> res = new ArrayList<>();

        for(T s : list){
            res.add(f.apply(s));
        }

        return res;
    }

    public static void main(String[] args) {

        //例1,将字符串映射为它的长度
        List<String> strList = Arrays.asList("sayHello", "world", "123");
        List<Integer> lenList = map(strList, s -> s.length());
        System.out.println(lenList);

        //例2
        IntFunction<Double> f = i -> i * 100.0d;
        System.out.println(f.apply(10));
    }
}
