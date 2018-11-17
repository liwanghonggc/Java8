package com.lwh.java8.chp2.demo1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author lwh
 * @date 2018-11-17
 * @desp 映射之扁平化
 */
public class Demo4Stream {

    /**
     * 对于一张单词表,如何返回一张列表,列出里面各不相同的字符呢?例如,给定单词列表
     * ["Hello","World"],你想要返回列表["H","e","l", "o","W","r","d"]
     */
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");

        //错误的写法1
        List<String[]> wordList = words.stream().map(word -> word.split("")).distinct().collect(toList());
        for (String[] str : wordList) {
            for (String s : str) {
                System.out.print(s);
            }
            System.out.println();
        }

        //错误的写法2,得到的是一个流的列表,Arrays.stream方法可以接收一个数组并产生一个流
        List<Stream<String>> collect = words.stream()
                                            .map(word -> word.split(""))
                                            .map(Arrays::stream)
                                            .distinct()
                                            .collect(toList());
        System.out.println(collect.size());

        //正确的解法,将各个生成流合并起来,扁平化为一个流
        List<String> uinqueChar = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(uinqueChar);
    }
}
