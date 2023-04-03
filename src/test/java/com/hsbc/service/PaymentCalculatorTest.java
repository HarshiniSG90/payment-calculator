package com.hsbc.service;

import com.hsbc.dto.Currency;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PaymentCalculatorTest {

    private PaymentCalculator paymentCalculator;
    private Payment payment;

    @Test
    public void testStartAndQuit() {
        String input = "quit";
        Scanner mockScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        paymentCalculator.setScanner(mockScanner);
        paymentCalculator.addPayment();
        assertFalse(paymentCalculator.isRunning());
    }

    @Test
    public void testInvalidInput() {
        String input = "ABC\nquit\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        paymentCalculator.addPayment();
        assertFalse(paymentCalculator.isRunning());
    }
}
