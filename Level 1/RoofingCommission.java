// Roofing Commission - Java 3C
// Eileen Luloh - Sum '23

import javax.swing.*; //JFrame

public class RoofingCommission
{
   public static void main(String [] args)
   {
      int numRoofs = 0;
      double commissionPercent, salesPrice, totalCommission;
      double totalPrice = 0;
      
      numRoofs = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of roofs sold."));
      commissionPercent = Double.parseDouble(JOptionPane.showInputDialog("Please enter the commission percentage."));
      
      System.out.printf("ROOF\t\t\tSALES\tPRICE");
      
      for (int i = 1; i <= numRoofs; i++)
      {
         salesPrice = Double.parseDouble(JOptionPane.showInputDialog("Please enter the sales price for roof " + i));
         totalPrice += salesPrice;
         
         System.out.printf("\n%3d\t\t\t$%,10.2f", i, salesPrice);
      }
      
      totalCommission = commissionPercent / 100.0 * totalPrice;   
      
      System.out.printf("\n" + String.format("%10s", "TOTAL") + "\t$%,10.2f\n" + String.format("%10s", "COMMISSION") 
            + "\t$%,10.2f", totalPrice, totalCommission); 
      System.exit(0);  
      
   }
}
