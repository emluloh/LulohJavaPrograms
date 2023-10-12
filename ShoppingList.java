// List of Shopping Items - Java 6A
// Eileen Luloh - Sum '23

import java.util.ArrayList;

public class ShoppingList
{
   public static void main(String [] args)
   {
      ArrayList<String> shoppingList = new ArrayList<String>();
      
      //hardcode all items to array
      shoppingList.add("Milk");
      shoppingList.add("Flour");
      shoppingList.add("Eggs");
      shoppingList.add("Bread");
      shoppingList.add("Lettuce");
      shoppingList.add("Tomatoes");
      shoppingList.add("Pickles");
      shoppingList.add("Hummus");
      
      //print header
      System.out.println("List of Shopping Items\n--------------");
      
      for (int i = 0; i < shoppingList.size(); i++)
      {
         System.out.println(shoppingList.get(i));
      } 
      
      //vegetarian replacement for eggs
      shoppingList.set(2, "Applesauce");
      
      //add a dessert item
      shoppingList.add(0, "Nutella Pizza");
      
      //print header
      System.out.println("\n\nList of Shopping Items\n--------------");
      
      for (int i = 0; i < shoppingList.size(); i++)
      {
         System.out.println(shoppingList.get(i));
      }
   }
}