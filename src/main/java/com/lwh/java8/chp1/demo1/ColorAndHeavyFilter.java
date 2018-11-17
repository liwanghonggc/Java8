package com.lwh.java8.chp1.demo1;

import com.lwh.java8.chp1.Apple;

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
