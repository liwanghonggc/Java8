package com.lwh.java8.chp2.demo2;

import com.lwh.java8.chp2.demo1.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp
 */
public class PredicateDemo {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> res = new ArrayList<>();
        for(T t : list){
            if(p.test(t)){
                res.add(t);
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
    }
}
