// Fed Tax Payer Validation - Java 3B
// Eileen Luloh - Sum '23

import javax.swing.*; //JFrame

public class FedTaxPayerValidation
{
   public static void main (String [] args)
   {
      String ssn;
      String inputMarital;
      char maritalStatus;
      
      // ask the user for the value
      ssn = JOptionPane.showInputDialog("Please enter your SSN.");
      
      // while ssn length doesn't equal 9, and is less than 100000000, keep asking for input
      while (ssn.length() != 9 || ssn.compareTo("100000000") < 0)
      {
         if (ssn.length() != 9)
         {
            ssn = JOptionPane.showInputDialog("Invalid length. Please enter a 9 digit number.");
         } else if (ssn.compareTo("100000000") < 0)
         {
            JOptionPane.showInputDialog("Invalid size. Please enter a number above 100000000.");
            ssn = ""; // 9 spaces are allocated for string ssn without this and gives wrong error
         }
      }
      
      // ask the user for marital status
      inputMarital = JOptionPane.showInputDialog("Please enter your Marital Status. M - Married, "
            + "S - Single, H - head of household");
      maritalStatus = Character.toUpperCase(inputMarital.charAt(0));
      
      // while marital status input is invalid, keep asking for input
      while (maritalStatus != 'M' && maritalStatus != 'S' && maritalStatus != 'H')
      {
          inputMarital = JOptionPane.showInputDialog("Invalid Marital Status. Please enter M, "
               + "S, or H for your marital status.");
               maritalStatus = Character.toUpperCase(inputMarital.charAt(0));
      }
      
      // if maritalStatus equals M, M gets returned to maritalStatus (same with S), else H
      maritalStatus = (maritalStatus == 'M') ? 'M' : (maritalStatus == 'S') ? 'S' : 'H';
      System.out.println("SSN: " + ssn + "\nMarital Status: " + maritalStatus);
      System.exit(0);
   }
}
