// Truck Selection (Array) - Java 6A
// Eileen Luloh - Sum '23

import java.util.Scanner;

public class TruckSelectionArray
{
   public static void main(String [] args)
   {      
      final int NUM_TRUCKS = 4; //number of truckList
      
      // Create an array that can reference Truck objects
      Truck[] truckList = new Truck[NUM_TRUCKS];
      
      // create objects for the array
      truckList[0] = new Truck("F150", "Full-sized Pickup 1.5 Ton", 33695);
      truckList[1] = new Truck("F250", "Super Duty 2.5 Ton", 43970);
      truckList[2] = new Truck("F350", "Super Duty 3.5 Ton", 45015);
      truckList[3] = new Truck("F450", "Super Duty 4.5 Ton", 58455);
      
      // Print header
      System.out.println("Truck models available");
      System.out.println("----------------------");
      
      // Display truck list
      for (int i = 0; i < truckList.length; i++)
      {
         System.out.println(truckList[i].getTruckModel());
      }
      
      // Ask the user which truck they want to select
      Scanner keyboard = new Scanner(System.in);
      System.out.println("\nPlease enter in a truck model: ");
      String inputTruck = keyboard.next().toUpperCase();
      
      // Perform a linear search to find truck user wants
      int count = 0;
      while (count < truckList.length && !inputTruck.equals(truckList[count].getTruckModel()))
      {
         count++;
      }
      
      if (count < truckList.length)
      {
         System.out.println("Model: " + truckList[count].getTruckModel());
         System.out.println("Description: " + truckList[count].getTruckDesc());
         System.out.printf("Price: $%,.2f", truckList[count].getTruckPrice());
      }
      else
      {
         System.out.println("Invalid truck model entered.");
      }
   }  
}

