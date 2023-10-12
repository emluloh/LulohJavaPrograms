// Computer Loan App - Java 4C
// Eileen Luloh - Sum '23

import java.util.Scanner;

public class ComputerLoanApp
{
   public static void main(String [] args)
   {
      double price, interestRate, paymentAmt;
      int numPayments;
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("Please enter the price of the computer being purchased: ");
      price = keyboard.nextDouble();
      
      System.out.printf("Please enter the interest rate as percentage: ");
      interestRate = keyboard.nextDouble() / 100 / 12;
      
      System.out.printf("Please enter the number of payments: ");
      numPayments = keyboard.nextInt();
      
      paymentAmt = calcPaymentAmt(price, interestRate, numPayments);
      System.out.printf("Payment Amount: $%,.2f%n%n", paymentAmt);
      
      printAmortSchedule(price, interestRate, numPayments, paymentAmt);
   
   }
   
   private static double calcPaymentAmt(double price, double interestRate, int numPayments)
   {
        return (price * interestRate) / (1 - Math.pow(1 + interestRate, -numPayments));
   }
   
   private static void printAmortSchedule(double price, double interestRate, int numPayments, double paymentAmt)
   {
      double balance, principal, interest, endBalance;
      balance = price;
      
      System.out.printf("%-4s\t\t%-14s\t\t%-10s\t\t%-10s\t\t%-14s%n", "Pymt", "Beg Balance", "Prin", "Interest", "End Balance");
      for (int i = 1; i <= numPayments; i++)
      {
         interest = balance * interestRate;
         principal = paymentAmt - interest;
         endBalance = balance - principal;
         
         System.out.printf("%4d\t\t$\t%,8.2f\t\t\t$%,8.2f\t\t$%,8.2f\t\t$\t%,8.2f%n", i, balance, principal, interest, endBalance);

         balance = endBalance;
      }
   }
}

