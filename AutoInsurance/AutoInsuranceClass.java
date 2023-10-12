// Auto Insurance Class - Java 3C
// Eileen Luloh - Sum '23

// The lines in the UML "setYear" and "getCarYear" are mismatched so I made
// them both "setCarYear" and "getCarYear"

public class AutoInsuranceClass
{
   public static void main(String [] args)
   {
      AutoIns car1 = new AutoIns();
      car1.setName("MICHAEL FATHI");
      car1.setPolicyNumber("MF12345");
      car1.setCarMake("TOYOTA");
      car1.setCarModel("COROLLA");
      car1.setCarYear(2022);
      car1.setEffectiveDate("06/01/2023");
      car1.setExpirationDate("05/31/2024");
      car1.setVIN("TX329593023");
   
      AutoIns car2 = new AutoIns("SOURAV CHATTERJEE", "SC12593");
      car2.setCarMake("HONDA");
      car2.setCarModel("CRX");
      car2.setCarYear("2020");
      car2.setEffectiveDate("03/01/2023");
      car2.setExpirationDate("02/29/2024");
      car2.setVIN("TX559564232");
      
      AutoIns car3 = new AutoIns("DIPAK PRAVIN", "DP32953", "INFINITI", "QX65", 2014, "08/01/2023", "07/31/2024", "TX23940952");
      
      printCarInfo(car1);
      printCarInfo(car2);
      printCarInfo(car3);
   }  
   
   // The printCarInfo method does the same thing as writing out car1.getWhateverInfo();, 
   // car2.getWhateverInfo();, etc., but passes car1 as an argument into the car parameter, 
   // prints it, passes car2 as an argument into the car parameter, prints that, etc.
   // TLDR AutoIns car param accepts an AutoIns object as an arg, doesn't create a new AutoIns object
   private static void printCarInfo(AutoIns car)
   {
      System.out.println("Insured: " + car.getName());
      System.out.println("Policy #: " + car.getPolicyNumber());
      System.out.println("Make: " + car.getCarMake());
      System.out.println("Model: " + car.getCarModel());
      System.out.println("Year: " + car.getCarYear());
      System.out.println("Effective Date: " + car.getEffectiveDate());
      System.out.println("Expiration Date: " + car.getExpirationDate());
      System.out.println("VIN: " + car.getVIN());
      System.out.println();
   }
}