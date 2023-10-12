// Wage Calculator - Java 2C
// Eileen Luloh - Sum '23


import java.util.Scanner;

public class CalcSalaryOrHours
{
   public static void main (String [] args)
   {
      double salary = 0;
      double hourlyRate = 0;
      double hours = 0;
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter S to calculate salary.\nEnter R to calculate " + 
            "hourly rate.\nEnter H to calculate the number of hours.");
      String userInput = keyboard.nextLine().toUpperCase();
      System.out.println(userInput);
      
      if (userInput.equals("S"))
      {
         System.out.println("What is your hourly rate?");
         hourlyRate = keyboard.nextDouble();
         salary = hourlyRate * 2080;
         /*System.out.printf("At " + String.format("$%,.2f", hourlyRate) + "/hour, " +
               "your salary would be " + String.format("$%,.2f", salary));*/
         System.out.printf("At $%,.2f/hour, your salary would be $%,.2f", hourlyRate, salary);
      }
      else if (userInput.equals("R"))
      {
         System.out.println("What is your annual salary?");
         salary = keyboard.nextDouble();
         hourlyRate = salary / 2080;
         System.out.printf("A salary of " + String.format("$%,.2f", salary) + " is " + 
               String.format("$%,.2f", hourlyRate) + " per hour");
      }
      else if (userInput.equals("H"))
      {
         System.out.println("What is your desired annual salary?");
         salary = keyboard.nextDouble();
         System.out.println("What is your hourly rate?");
         hourlyRate = keyboard.nextDouble();
         hours = salary / hourlyRate;
         System.out.printf("A salary of " + String.format("$%,.2f", salary) + " at " + 
               String.format("$%,.2f", hourlyRate) + "/hour would take " + 
               String.format("%,.2f", hours) + " hours");
      }
      else
      {
      System.out.println("Error. Please enter a valid option.");
      }
   } // end of main
} // end of class
