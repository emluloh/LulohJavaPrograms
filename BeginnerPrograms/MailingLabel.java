// Mailing Label - Java 4A
// Eileen Luloh - Sum '23

import java.util.Scanner;

public class MailingLabel
{
   public static void main(String [] args)
   {
      String name = "";
      String address = "";
      String cityStateZip = "";
      
      name = getName(name);
      address = getAddress(address);
      cityStateZip = getCityStateZip(cityStateZip);
      printMailingInfo(name, address, cityStateZip);
   }
   
   private static String getName(String name)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter name: ");
      name = keyboard.nextLine();
      return name;
   }
   
   private static String getAddress(String address)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter address: ");
      address = keyboard.nextLine();
      return address;
   }
   
   private static String getCityStateZip(String cityStateZip)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter city, state, and zip code: ");
      cityStateZip = keyboard.nextLine();
      return cityStateZip;
   }
   
   private static void printMailingInfo(String name, String address, String cityStateZip)
   {
      System.out.println("\n" + name + "\n" + address + "\n" + cityStateZip);
   }
   
   
}

