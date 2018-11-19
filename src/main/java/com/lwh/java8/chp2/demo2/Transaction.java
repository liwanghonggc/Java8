package com.lwh.java8.chp2.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 交易
 */
@Data
@AllArgsConstructor
public class Transaction {
    private final Trader trader;

    private final int year;

    private final int value;

}
