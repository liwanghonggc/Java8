package com.lwh.java8.chp2.demo2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp
 */
public class Practise {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> trans = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2013, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //(1) 找出2011年发生的所有交易,并按交易额排序(从低到高)
        trans.stream().filter(t -> t.getYear() == 2011)
                      .sorted(comparing(Transaction::getValue))
                      .forEach(System.out::println);

        System.out.println("...........................");

        //(2) 交易员都在哪些不同的城市工作过?
        trans.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        Set<String> cities = trans.stream().map(t -> t.getTrader().getCity()).collect(toSet());
        System.out.println(cities);

        System.out.println("...........................");

        //(3) 查找所有来自于剑桥的交易员,并按姓名排序
        trans.stream().map(Transaction::getTrader).filter(t -> "Cambridge".equals(t.getCity())).distinct()
                      .sorted(comparing(Trader::getName)).forEach(System.out::println);

        System.out.println("...........................");

        //(4) 返回所有交易员的姓名字符串,按字母顺序排序
        String namesStr1 = trans.stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("", (s1, s2) -> s1 + s2);
        System.out.println(namesStr1);

        String namesStr2 = trans.stream().map(t -> t.getTrader().getName()).distinct().sorted().collect(joining(", "));
        System.out.println(namesStr2);

        System.out.println("...........................");

        //(5) 有没有交易员是在米兰工作的?
        boolean isMilan = trans.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println(isMilan);

        System.out.println("...........................");

        //(6) 打印生活在剑桥的交易员的所有交易额
        List<Integer> tradeNum = trans.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).collect(toList());
        System.out.println(tradeNum);

        System.out.println("...........................");

        //(7) 所有交易中,最高的交易额是多少?
        Optional<Integer> maxTradeValue = trans.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(maxTradeValue);

        System.out.println("...........................");

        //(8) 找到交易额最小的交易
        List<Transaction> minTrade1 = trans.stream().sorted(comparing(Transaction::getValue)).limit(1).collect(toList());
        System.out.println(minTrade1);

        Optional<Transaction> minTrade2 = trans.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(minTrade2);

        Optional<Transaction> minTrade3 = trans.stream().min(comparing(Transaction::getValue));
        System.out.println(minTrade3);

    }
}
