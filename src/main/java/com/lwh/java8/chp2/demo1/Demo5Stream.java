package com.lwh.java8.chp2.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 练习
 */
public class Demo5Stream {

    public static void main(String[] args) {
        //例1: 给定一个数字列表,如何返回一个由每个数的平方构成的列表呢?例如,给定[1, 2, 3, 4,5],应该返回[1, 4, 9, 16, 25]
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map(n -> n * n).forEach(System.out::println);

        System.out.println("..............................");

        //例2: 给定两个数字列表,如何返回所有的数对呢?例如,给定列表[1, 2, 3]和列表[3, 4],应该返回[(1, 3),(1, 4),(2, 3),(2, 4),(3, 3),(3, 4)]
        List<Integer> nums1 = Arrays.asList(1, 2, 3);
        List<Integer> nums2 = Arrays.asList(3, 4);

        List<Stream<int[]>> collect = nums1.stream().map(i -> nums2.stream().map(j -> new int[]{i, j})).collect(toList());

        System.out.println(collect.size());
        Stream<int[]> stream = collect.get(0);
        List<int[]> list = stream.collect(toList());
        for(int i = 0; i < list.size(); i++){
            int[] num = list.get(i);
            System.out.println(Arrays.toString(num));
        }

        System.out.println("..............................");

        List<int[]> res1 = nums1.stream().flatMap(i -> nums2.stream().map(j -> new int[]{i, j})).collect(toList());
        for(int i = 0; i < res1.size(); i++){
            System.out.println(Arrays.toString(res1.get(i)));
        }

        System.out.println("..............................");

        //如何扩展前一个例子,只返回总和能被3整除的数对呢?例如(2, 4)和(3, 3)是可以的
        List<int[]> res2 = nums1.stream().flatMap(i -> nums2.stream()
                                                            .filter(j -> (i + j) % 3 == 0)
                                                            .map(j -> new int[]{i, j})
                                                 )
                                         .collect(toList());
        for(int i = 0; i < res2.size(); i++){
            System.out.println(Arrays.toString(res2.get(i)));
        }


    }
}
