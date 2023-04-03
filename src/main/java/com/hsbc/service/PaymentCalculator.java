package com.hsbc.service;

import com.hsbc.dto.Currency;
import lombok.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@Data
public class PaymentCalculator {
    private Payment payment;
    private Scanner scanner;
    private boolean running;
    private String fileName;

    public PaymentCalculator() {
        payment = new Payment();
        scanner = new Scanner(System.in);
        running = true;
    }


    public PaymentCalculator(String filename) {
        this();
        this.fileName = filename;
    }

    public void addPayment() {
        while (isRunning()) {
            System.out.print("Enter payment (currency amount): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                running = false;
                System.out.println(" you are quiting the process!");
            } else {
                String[] parts = input.split("\\s+");
                if (parts.length != 2) {
                    System.out.println("Invalid input. Please enter currency and amount separated by a space."+input);
                } else {
                    try {
                        String currency = parts[0].toUpperCase();
                        if(currency.length() >3) {
                            System.out.println("Invalid input :: "+currency+" Please enter the curreny code with 3 capital letter for e.g. USD, HKD, CNY, NZD, GBP");
                        }
                        else {
                            double amount = Double.parseDouble(parts[1]);
                            Currency currencyDetail = new Currency(currency, amount);
                            payment.updatePayment(currencyDetail);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Amount must be a number.");
                        scanner.close();
                    }
                }
            }
            try {
               TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                scanner.close();
            }
            payment.displayPayments();
        }
        scanner.close();
    }

    private void uploadPaymentsUsingFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        try (Scanner fileScanner = new Scanner(new File(classLoader.getResource(fileName).getFile()))) {
            while (fileScanner.hasNextLine()) {
                String input = fileScanner.nextLine();
                String[] parts = input.split("\\s+");
                if (parts.length == 2) {
                    String currency = parts[0].toUpperCase();
                    double amount = Double.parseDouble(parts[1]);
                    Currency currencyDetail = new Currency(currency,amount);
                    payment.updatePayment(currencyDetail);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input in file: " + fileName);
        }
    }


    public static void main(String[] args) {

        if(args.length == 1) {
            PaymentCalculator calculator = new PaymentCalculator(args[0]);
            calculator.uploadPaymentsUsingFile();
            calculator.addPayment();
        } else {
            PaymentCalculator calculator = new PaymentCalculator();
            calculator.addPayment();
        }
    }



    public boolean isRunning() {
        return running;
    }

}

