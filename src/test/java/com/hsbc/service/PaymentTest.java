package com.hsbc.service;

import com.hsbc.dto.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PaymentTest {

    private Map<String, Double> balances;
    private Payment payment;
    private Currency currency;

    @BeforeEach
    public void setUp() {
        payment = new Payment();
        balances = new HashMap<>();
        balances.put("USD", 100.0);
        balances.put("CNY", 20.0);
        balances.put("INR", 300.0);
        balances.put("GBP", 50.0);
    }

    @Test
    public void testUpdatePayment() {

        payment.updatePayment(new Currency("USD", 100));
        assertEquals(100, payment.getPayment("USD"), 0.001);

        payment.updatePayment(new Currency("USD", -50));
        assertEquals(50, payment.getPayment("USD"), 0.001);

        payment.updatePayment(new Currency("EUR", 200));
        assertEquals(200, payment.getPayment("EUR"), 0.001);

        payment.updatePayment(new Currency("CNY", 50));
        assertEquals(50, payment.getPayment("CNY"), 0.001);

        assertFalse(balances.containsKey("NZD"));
    }

}
