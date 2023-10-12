// Supply List - Java 3A
// Eileen Luloh - Sum '23

import javax.swing.*; //JFrame

public class SupplyList
{
   public static void main (String [] args)
   {
      String productName = "";
      int quantity;
      double price, totalPrice, tax, totalCostWithTax;
      double totalCostNoTax = 0;
      final double TAX_RATE = 0.0825;
      
      
      String header = "PRODUCT\t\t\t\t\t\t\tQUANTITY\tUNIT\tPRICE\t\t\tPRICE";
      System.out.printf(header);
      
      do
      {
         productName = JOptionPane.showInputDialog("Enter the product name. " 
               + "(Leave blank if no more products.)");
               
               if (productName.equals("")) break;
               
         quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter "
               + "the quantity purchased."));
         price = Double.parseDouble(JOptionPane.showInputDialog("Enter the "
               + "price of the product."));
               
         totalPrice = price * quantity;
         totalCostNoTax += totalPrice;
         
         System.out.printf("\n%-25s%,6d\t\t  $%,8.2f\t\t$%,7.2f",
               productName, quantity, price, totalPrice);
      } while (!productName.equals(""));
      
      tax = totalCostNoTax * TAX_RATE;
      totalCostWithTax = totalCostNoTax + tax;
      
      System.out.printf("\n" + String.format("%50s", "TOTAL\t") + "$%,7.2f\n"
            + String.format("%50s", "TAX\t") + "$%,7.2f\n"
            + String.format("%50s", "TOTAL COST\t") + "$%,7.2f\n", 
            + totalCostNoTax, tax, totalCostWithTax);
      System.exit(0);
   }
}
