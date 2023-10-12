// Ford Truck Selection - Java 2B
// Eileen Luloh - Sum '23


import java.util.Scanner;

public class FordTruckSelection
{
   public static void main (String [] args)
   {
      double truckPrice = 0; // program gets upset if not initialized
      String truckDescrip = null;
      double calcTax, totalPrice;
      final double SALES_TAX = 0.0825;
      Boolean err = false;
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Select a truck mode\nF150\nF250\nF350\nF450");
      String userChoice = keyboard.nextLine();
      
      switch (userChoice.toUpperCase())
      {
         case "F150":
            truckPrice = 33695;
            truckDescrip = "You selected Ford F150 - Full-sized Pickup 1.5 Ton";
            break;
         case "F250":
            truckPrice = 43970;
            truckDescrip = "You selected Ford F250 - Super Duty 2.5 Ton";
            break;
         case "F350":
            truckPrice = 45015;
            truckDescrip = "You selected Ford F350 - Super Duty 3.5 Ton";
            break;
         case "F450":
            truckPrice = 58455;
            truckDescrip = "You selected Ford F450 - Super Duty 4.5 Ton";
            break;
         default:
            err = true;
            break;
      } // end of switch
     
      if (err == false) // option is valid
      {
         // print truck info
         calcTax = truckPrice * SALES_TAX;
         totalPrice = truckPrice + calcTax;
            
         System.out.printf(truckDescrip + "\nThe price is\t\t\t" + 
               String.format("$%,.2f", truckPrice) + "\nThe sales tax is\t\t" + 
               String.format("$%,.2f", calcTax) + "\nThe total price is\t" + 
               String.format("$%,.2f", totalPrice));
      }
      else // option is invalid
      {
         // print error message
         System.out.println("Error. Please enter a valid truck option.");
      }   
   } // end of main
} // end of class
