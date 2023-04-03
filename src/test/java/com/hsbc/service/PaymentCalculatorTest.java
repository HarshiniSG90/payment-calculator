package com.hsbc.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
/*
 * PaymentCalculatorTest which helps in running test cases to test Payment calculator class behaviour
 * */
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
