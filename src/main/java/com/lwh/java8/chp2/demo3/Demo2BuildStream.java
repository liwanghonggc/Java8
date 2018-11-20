package com.lwh.java8.chp2.demo3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 构建流
 */
public class Demo2BuildStream {

    public static void main(String[] args) {
        //1) 由值创建流,通过静态方法Stream.of()
        Stream<String> strStream = Stream.of("Java 8", "Lambda", "In", "Action");
        strStream.map(String::toUpperCase).forEach(System.out::println);

        //2) 由数组创建流
        int[] nums = {2, 3, 5, 11};
        int sum = Arrays.stream(nums).sum();
        System.out.println(sum);

        //3) 由文件生成流
        long uniqueChars = 0;
        try(Stream<String> lines = Files.lines(Paths.get("D:\\Software\\IDEA\\Projects\\Java8\\src\\main\\java\\com\\lwh\\java8\\chp2\\demo3\\data.txt"), Charset.defaultCharset())){
            uniqueChars = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                               .distinct()
                               .count();
            System.out.println(uniqueChars);
        }catch (IOException e){
            e.printStackTrace();
        }

        //4) 由函数生成流

        //4.1) 迭代
        Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);

        //4.2) 生成
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }
}
