// Calculate Tax App - Java 4B
// Eileen Luloh - Sum '23

import java.util.Scanner;


public class CalculateTaxApp
{
   public static void main (String [] args)
   {
      String name, state;
      double annualIncome = 0;
      double taxAmount = 0;
   
      Scanner keyboard = new Scanner(System.in);
   
      System.out.print("Please enter your name: ");
      name = keyboard.nextLine();
      
      System.out.print("Please enter your annual income: ");
      annualIncome = keyboard.nextDouble();
   
      System.out.print("Please enter the state you live in (AZ, MI, NM, or LA): ");
      state = keyboard.next();
   
      switch (state.toUpperCase())
      {
         case "AZ":
            state = "ARIZONA (AZ)";
            taxAmount = calcArizonaTax(annualIncome);
            break;
         case "MI":
            state = "MICHIGAN (MI)";
            taxAmount = calcMichiganTax(annualIncome);
            break;
         case "NM":
            state = "NEW MEXICO (NM)";
            taxAmount = calcNewMexicoTax(annualIncome);
            break;
         case "LA":
            state = "LOUISIANA (LA)";
            taxAmount = calcLouisianaTax(annualIncome);
            break;
         default:
            System.out.println("Invalid state entered.");
            System.exit(0);
      }
      
      printTaxInfo(name, state, annualIncome, taxAmount);
   } // end of main
   
   private static double calcArizonaTax(double annualIncome)
   {
      return annualIncome * .024;
   }
   
   private static double calcMichiganTax(double annualIncome)
   {
      return annualIncome * .0405;
   }
   
   private static double calcNewMexicoTax(double annualIncome)
   {
      return annualIncome * .049;
   }
   
   private static double calcLouisianaTax(double annualIncome)
   {  
      double withholdingTax = 0; // W, withholding tax per pay period, found through calculation
      double employeeSalary; // S, employee's salary per pay period (annualIncome/numPayPeriods)
      int personalExemptions = 0; // X, number of personal exemptions, X must be 0 or 1
      int dependencyCredits; // Y, number of dependency credits, Y must be a whole number that 
                             // is 0 or greater
      int numPayPeriods = 1; // N, number of pay periods (initialized to 1 per the hints/tips)
      double belowExcess; // A, the effect of the personal exemptions and dependency
                                      // credits equal to or less than $12,500
      double aboveExcess; // B, the effect of the personal exemptions and dependency
                                      // credits in excess of $12,500
      char marriageStatus;
      
      Scanner keyboard = new Scanner(System.in);

      System.out.println("Are you single or married? Enter S - single or M - married: ");
      marriageStatus = keyboard.nextLine().toUpperCase().charAt(0);
      while (marriageStatus != 'S' && marriageStatus != 'M')
      {
      System.out.println("Invalid marriage status. Please enter either S or M: ");
      marriageStatus = keyboard.nextLine().toUpperCase().charAt(0);
      }
      
      System.out.println("Please enter the number of personal exemptions (0-2): ");
      switch (marriageStatus)
      {
         case 'S':
            personalExemptions = keyboard.nextInt();
            while (personalExemptions > 1 || personalExemptions < 0) // personalExemptions validation
            {
               System.out.println("Invalid number of personal exemptions. Please enter a number between 0 and 1: ");
               personalExemptions = keyboard.nextInt();
            }
            break;
         case 'M':
            personalExemptions = 2;
            System.out.println("Since the user entered married for marriage status, the number of personal exemptions will be set to 2.");
            break;
      }
      
      System.out.println("Please enter the number of dependency credits (0 or greater): ");
      dependencyCredits = keyboard.nextInt();
      while (dependencyCredits < 0) // dependencyCredits validation
      {
         System.out.println("Invalid number of dependency credits. Please enter 0 or greater: ");
         dependencyCredits = keyboard.nextInt();
      }
      
         dependencyCredits = (dependencyCredits <= 0) ? 0 : dependencyCredits;
         annualIncome = (annualIncome <= 0) ? 0 : annualIncome;
         // ask for numPayPeriods, while numPayPeriods is less than 1, repeat until valid input
         employeeSalary = annualIncome / numPayPeriods; // one pay period annually per hints/tips
           
         belowExcess = .021*(((personalExemptions*4500)+(dependencyCredits*1000))/numPayPeriods);
         belowExcess = (belowExcess <= 0) ? 0 : belowExcess;
         
      if (personalExemptions == 0 || personalExemptions == 1) //if single
      {
         aboveExcess = .016*((((personalExemptions*4500)+(dependencyCredits*1000))-12500)/numPayPeriods);
         aboveExcess = (aboveExcess <= 0) ? 0 : aboveExcess;
         if (annualIncome <= 12500)
         {
            withholdingTax = .021*(employeeSalary)-(belowExcess+aboveExcess);
         }
         else if (annualIncome > 12500 && annualIncome <= 50000)
         {
            withholdingTax = .021*(employeeSalary)+.016*(employeeSalary-(12500/numPayPeriods))-(belowExcess+aboveExcess);
         }
         else // annualIncome > 50000
         {
            withholdingTax = .021*(employeeSalary)+.016*(employeeSalary-(12500/numPayPeriods))+.0135*(employeeSalary-(50000/numPayPeriods))-(belowExcess+aboveExcess);
         }
      }
      else if (personalExemptions == 2) //if married
      {
         aboveExcess = .0165*((((personalExemptions*4500)+(dependencyCredits*1000))-25000)/numPayPeriods);
         aboveExcess = (aboveExcess <= 0) ? 0 : aboveExcess;
         if (annualIncome <= 25000)
         {
            withholdingTax = .021*(employeeSalary)-(belowExcess+aboveExcess);
         }
         else if (annualIncome > 25000 && annualIncome <= 100000)
         {
            withholdingTax = .021*(employeeSalary)+.0165*(employeeSalary-(25000/numPayPeriods))-(belowExcess+aboveExcess);
         }
         else // annualIncome > 100000
         {
            withholdingTax = .021*(employeeSalary)+.0165*(employeeSalary-(25000/numPayPeriods))+.0135*(employeeSalary-(100000/numPayPeriods))-(belowExcess+aboveExcess);
         }
      }
      return annualIncome = withholdingTax * numPayPeriods;
   }
   
   private static void printTaxInfo(String name, String state, double annualIncome, double taxAmount)
   {
      System.out.printf("\nName: %s\nState: %s\nAnnual Income: $%,.2f\nState Tax: $%,.2f", 
            name.toUpperCase(), state.toUpperCase(), annualIncome, taxAmount);
   }
   
}

