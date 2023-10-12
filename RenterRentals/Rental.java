// Rental Renters - Java 5B
// Eileen Luloh - Sum '23

public class Rental
{
   private String renterName; //nam
   private String propAddress; //addr
   private String cityStateZip; //csz
   private int numBedrooms; //beds
   private double numBathrooms; //baths
   private double squareFeet; //sqft
   
   public Rental() // first renter object instantiated with no args passed
   {}
   
   public Rental(String nam)
   {
      renterName = nam;
   }
   
   public Rental(String nam, String addr, String csz, int beds, double baths, double sqft)
   {
      renterName = nam;
      propAddress = addr;
      cityStateZip = csz;
      numBedrooms = beds;
      numBathrooms = baths;
      squareFeet = sqft;
   }
   
   public void setRenterName(String nam)
   {
      renterName = nam;
   }
   
   public void setPropertyAddress(String addr)
   {
      propAddress = addr;
   }
   
   public void setCityStateZip(String csz)
   {
      cityStateZip = csz;
   }
   
   public void setNumBedrooms(int beds)
   {
      numBedrooms = beds;
   }
   
   public void setNumBathrooms(double baths)
   {
      numBathrooms = baths;
   }
   
   public void setSquareFeet(double sqft)
   {
      squareFeet = sqft;
   }
   
   
   public String getRenterName()
   {
      return renterName;
   }
   
   public String getPropertyAddress()
   {
      return propAddress;
   }
   
   public String getCityStateZip()
   {
      return cityStateZip;
   }
   
   public int getNumBedrooms()
   {
      return numBedrooms;
   }
   
   public double getNumBathrooms()
   {
      return numBathrooms;
   }
   
   public double getSquareFeet()
   {
      return squareFeet;
   }
   
   public double getRentalPrice()
   {
      return (squareFeet * 0.65) + (numBedrooms * 50) + (numBathrooms * 35);
   }
}