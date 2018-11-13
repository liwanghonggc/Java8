package com.lwh.java8.chp2.demo2;

/**
 * @author lwh
 * @date 2018-11-13
 * @desp 非重点,接下来将Java8中几个非常重要的FunctionalInterface
 *       如Predicate, Consumer, Function, Supplier
 */
public class LambdaDemo2 {

    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello World1");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World2");
            }
        };

        process(r1);

        process(r2);

        process(() -> System.out.println("Hello World3"));
    }

    public static void process(Runnable r){
        r.run();
    }
}
