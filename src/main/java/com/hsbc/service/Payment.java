package com.hsbc.service;


import com.hsbc.dto.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;
/*
* This is the Payment Utility Class which helps in updating the payment,
* displaying the payment.
* */

@AllArgsConstructor
@Data
public class Payment {

    private Map<String, Double> balances;

    public Payment() {
        balances = new HashMap<>();
    }

    public void updatePayment(Currency currency) {
        if (balances.containsKey(currency.getCurrencyCode())) {
            double balance = balances.get(currency.getCurrencyCode()) + currency.getAmount();
            if (balance == 0) {
                balances.remove(currency.getCurrencyCode());
            } else {
                balances.put(currency.getCurrencyCode(), balance);
            }
        } else if (currency.getAmount() != 0) {
            balances.put(currency.getCurrencyCode(), currency.getAmount());
        }
    }

    public void displayPayments() {
        System.out.println("Current balances:");
        for (String currency : balances.keySet()) {
            double balance = balances.get(currency);
            if(!currency.equalsIgnoreCase("USD"))
            {
                double exchangeRate = getExchangeRate(currency);
                double usdAmount = balance / exchangeRate;
                System.out.printf("%s %.2f (USD %.2f)\n", currency, balance, usdAmount);
            }
            else {
                System.out.printf("%s %.2f\n", currency, balance);
            }
        }
        if (balances.isEmpty()) {
            System.out.println("No balances to display.");
        }
        System.out.println();
    }

    public double getPayment(String currency) {
        if (balances.containsKey(currency)) {
            return balances.get(currency);
        } else
            return 0.0;
    }

    public double getExchangeRate(String currency) {
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("CNY", 6.29);
        exchangeRates.put("HKD", 0.13);
        exchangeRates.put("JPY", 0.0092);
        exchangeRates.put("EUR", 1.18);
        exchangeRates.put("GBP", 1.39);
        return exchangeRates.getOrDefault(currency, 1.0);
    }


}