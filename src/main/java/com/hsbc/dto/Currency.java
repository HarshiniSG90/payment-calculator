package com.hsbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
/*
 * Curreny Pojo class which has
 * Fields: String currencyCode and double amount
 * */
@AllArgsConstructor
@Data
public class Currency {

    String currencyCode;
    double amount;
}
