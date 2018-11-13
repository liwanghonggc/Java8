package com.lwh.java8.chp2.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp 根据条件过滤苹果
 */
public class FilterApple {

    /**
     * 例1
     */
    public static List<Apple> filterGreenApples(List<Apple> apples){
        List<Apple> res = new ArrayList<>();

        for(Apple apple : apples){
            //最好把green放在前面,避免空指针异常
            if("green".equals(apple.getColor())){
                res.add(apple);
            }
        }

        return res;
    }

    /**
     * 例2,以颜色作为参数
     */
    public static List<Apple> filterApplesWithColor(List<Apple> apples, String color){
        List<Apple> res = new ArrayList<>();

        for(Apple apple : apples){
            if(color.equals(apple.getColor())){
                res.add(apple);
            }
        }

        return res;
    }

    /**
     * 例3,以filter作为参数,也可以使用匿名内部类
     * 缺点?代码冗余,易混淆,见Java8实战P29,分析下匿名内部类的变量作用域
     */
    public static List<Apple> filterApplesWithFilter(List<Apple> apples, AppleFilter appleFilter){
        List<Apple> res = new ArrayList<>();

        for(Apple apple : apples){
            if(appleFilter.filter(apple)){
                res.add(apple);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        //Ctrl + Alt + V 快捷键, 选中变量后Tab快捷键
        List<Apple> apples = Arrays.asList(new Apple("red", 140), new Apple("green", 200),
                new Apple("green", 100));

        //例1
        List<Apple> greenApples = filterGreenApples(apples);

        //例2
        List<Apple> redApples = filterApplesWithColor(apples, "red");

        //例3,大多数情况下满足需求,但是如果需求是红色且小于150的呢?
        List<Apple> applesWithFilter = filterApplesWithFilter(apples, new ColorAndHeavyFilter());

        //例4,使用Lambda作为参数,左边IDEA有提示
        List<Apple> applesWithLambda = filterApplesWithFilter(apples, apple -> "red".equals(apple.getColor()));

        System.out.println(greenApples);
        System.out.println(redApples);
        System.out.println(applesWithFilter);
        System.out.println(applesWithLambda);
    }

}
