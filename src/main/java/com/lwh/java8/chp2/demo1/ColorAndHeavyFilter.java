package com.lwh.java8.chp2.demo1;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp
 */
public class ColorAndHeavyFilter implements AppleFilter{
    @Override
    public boolean filter(Apple apple) {
        return "green".equals(apple.getColor()) && apple.getWeight() > 150;
    }
}
