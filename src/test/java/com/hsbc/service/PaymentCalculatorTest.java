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
    @BeforeEach
    public void setUp() {
        paymentCalculator = new PaymentCalculator();
    }

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
        Scanner mockScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        paymentCalculator.setScanner(mockScanner);
        paymentCalculator.addPayment();
        assertFalse(paymentCalculator.isRunning());
    }
}
