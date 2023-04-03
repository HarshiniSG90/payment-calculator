package com.hsbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Currency {

    String currencyCode;
    double amount;
}
