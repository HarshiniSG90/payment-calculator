
# Payment Calculator

Write a program to calculate the balance of a dynamic series of payments per currency.

A payment has two fields: amount and currency. E.g.
USD 100
50 CNY
-30 GBP
200 EUR
A currency usually have 3 capital letters, e.g. USD, HKD, CNY, NZD, GBP
The user can enter a payment into the console by entering a currency, an amount and followed by hitting the enter key
The program outputs the balance of each currency to console every minute, until the user inputs “quit”
If the balance amount of a currency is 0, that currency should not be displayed.

Optional bonus questions:

The program can read initial input payments from a file whose path is provided as a parameter when starting the program
The output displays an exchanged amount compared to USD, if the currency is not USD. E.g.
USD 900
CNY 2000 (USD 314.60)
HKD 300 (USD 38.62)






## Instructions to run code

Compile the Java code and Execute main in PaymentCalculator.java in intellij / Eclipse

OR run the below command

```bash
  java –jar payment-calculator-1.0-SNAPSHOT.jar
```

1. When the program runs it will take input from command line console and output to console (stdout).

For Example: 
USD 100
INR 300
EUR 90

Note: Please make sure you enter USD 100 and click enter and then add INR 300 and so on..

Wait for 1 min to see each payment to display in the console.

2. This is for the optional bonus question
NOTE:
Please edit configuration in Intellij and add input.txt in program arguments.
then this will load the file with all payments.

Wait for 1 min to see each payment to display in the console. whenever any new payment is added in the console.

Limitations :
1. If the value is negative currently I am not considering any cases for that.

2. Every entry of the Payment is taking a min to display , but thats expected as per the problem statement. However in the second optional bonus question also I have implemented this 1 min lag.
This can be changed ofcouse if not required.

3. For some reason in my command line I am unable to enter multiple payments at a single shot, However its working perfectly fine with one payment and waiting for 1 min and then and payment needs to be added, However this is not the case with Intellij command line it working as expected. Sinc its time bound task I couldnt dig much into this error, Given some more time I can fix this issue.

Improvement:

1. I could have used Currency util for this solution instead of using String in Map of balances.
2. Can write more test cases to test all corner test cases.


