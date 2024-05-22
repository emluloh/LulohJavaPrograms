// Bulk Songs Purchase - Java 2A
// Eileen Luloh - Sum '23


import javax.swing.*; //JFrame
import java.text.DecimalFormat; //Format to 2 decimals

public class BulkSongsPurchase
{
   public static void main (String [] args)
   {
      double taxRate = 0.0825;
      int numSongs;
      double costBeforeTax, calcTax, totalPrice;
      double pricePerSong = 0; // assigned a default value bc program will get upset
   
      numSongs = Integer.parseInt(JOptionPane.showInputDialog(null, "How many songs are you downloading?"));
      if (numSongs >=1 && numSongs <= 5)
      {
         pricePerSong = 1.20;
      }
      else if (numSongs >=6 && numSongs <= 10)
      {
         pricePerSong = 1.10;
      }
      else if (numSongs >= 11 && numSongs <= 20)
      {
         pricePerSong = 1.00;
      }
      else if (numSongs > 20)
      {
         pricePerSong = 0.90;
      }
      else // added extra conditional for user error correction e.g. entering 0 or negative number
      {
         JOptionPane.showMessageDialog(null, "Invalid number of songs chosen.");
         System.exit(0);
      }
      
      costBeforeTax = pricePerSong * numSongs;
      calcTax = costBeforeTax * taxRate;
      totalPrice = costBeforeTax + calcTax;
      
      DecimalFormat numberFormat = new DecimalFormat("#.##");

      JOptionPane.showMessageDialog(null, "Songs downloaded: " + numSongs + "\nPrice per song: $" + numberFormat.format(pricePerSong) + "\nSong cost: $" + numberFormat.format(costBeforeTax) + "\nTax: $" + numberFormat.format(calcTax) + "\nPurchase price: $" + numberFormat.format(totalPrice)); 
   }
}
