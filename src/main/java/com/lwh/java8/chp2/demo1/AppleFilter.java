package com.lwh.java8.chp2.demo1;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp 策略模式
 *       Comparator, Runnable等也加了@FunctionalInterface
 *       分析下Comparator和Comparable的区别
 */

@FunctionalInterface
public interface AppleFilter {

    /**
     * 根据条件过滤苹果
     */
    boolean filter(Apple apple);
}
