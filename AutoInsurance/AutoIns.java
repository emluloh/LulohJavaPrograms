// Auto Insurance Class - Java 3C
// Eileen Luloh - Sum '23

public class AutoIns
{
   private String insName; //nam
   private String policyNumber; //polNum
   private String carMake; //make
   private String carModel; //mod
   private int carYear; //year
   private String effDate; //effect
   private String expDate; //expire
   private String VIN; //VINum
   
   public AutoIns() // first car object instantiated with no args passed
   {}
   
   public AutoIns(String nam, String polNum) // partial constructor
   {
      insName = nam;
      policyNumber = polNum;
   }
   
   public AutoIns(String nam, String polNum, String make, String mod, int year, 
         String effect, String expire, String VINum) // full constructor
   {
      insName = nam;
      policyNumber = polNum;
      carMake = make;
      carModel = mod;
      carYear = year;
      effDate = effect;
      expDate = expire;
      VIN = VINum;
   }
   
   // mutators
   public void setName(String nam)
   {
      insName = nam;
   }
   
   public void setPolicyNumber(String polNum)
   {
      policyNumber = polNum;
   }
   
   public void setCarMake(String mak)
   {
      carMake = mak;
   }
   
   public void setCarModel(String mod)
   {
      carModel = mod;
   }
   
   public void setCarYear(int year)
   {
      carYear = year;
   }
   
   public void setCarYear(String year)
   {
      carYear = Integer.parseInt(year);
   }
   
   public void setEffectiveDate(String effect)
   {
      effDate = effect;
   }
   
   public void setExpirationDate(String expire)
   {
      expDate = expire;
   }
   
   public void setVIN(String VINum)
   {
      VIN = VINum;
   }
   
   // accessors
   public String getName()
   {
      return insName;
   }
   
   public String getPolicyNumber()
   {
      return policyNumber;
   }
   
   public String getCarMake()
   {
      return carMake;
   }
   
   public String getCarModel()
   {
      return carModel;
   }
   
   public int getCarYear()
   {
      return carYear;
   }
   
   public String getEffectiveDate()
   {
      return effDate;
   }
   
   public String getExpirationDate()
   {
      return expDate;
   }
   
   public String getVIN()
   {
      return VIN;
   }
}
