package com.lwh.java8.chp1;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp 苹果类
 *       介绍下Lombok插件,使用Lombok需要安装插件,配置maven依赖,https://blog.csdn.net/motui/article/details/79012846
 *       lombok依赖其scope为provided,介绍下maven的scope作用域
 */

@Data
@AllArgsConstructor
public class Apple {

    private String color;

    private int weight;

    public static void main(String[] args) {
        Apple apple = new Apple("green", 150);
        System.out.println(apple.toString());
    }
}
