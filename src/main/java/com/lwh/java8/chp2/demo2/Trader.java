package com.lwh.java8.chp2.demo2;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lwh
 * @date 2018-11-19
 * @desp 交易员
 */

@Data
@AllArgsConstructor
public class Trader {

    private final String name;

    private final String city;
}
