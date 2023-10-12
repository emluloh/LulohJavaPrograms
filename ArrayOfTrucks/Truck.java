// Truck Class - Java 6B (Arrays)
// LeRoy Hardy - Sum '23

public class Truck
{
   private String truckModel ;
   private String truckDesc ;
   private double truckPrice ;
   
   public Truck()
   {
      truckPrice = 0.0;
   }
   public Truck(String model, String desc, double price)
   {
      truckModel = model ;
      truckDesc = desc ;
      truckPrice = price ;
   }
   public void setTruckModel(String model)
   {
      truckModel = model ;
   }
   public void setTruckDesc(String desc)
   {
      truckDesc = desc ;
   }
   public void setTruckPrice(double price)
   {
      truckPrice = price ;
   }
   public String getTruckModel()
   {
      return truckModel ;
   }
   public String getTruckDesc()
   {
      return truckDesc ;
   }
   public double getTruckPrice()
   {
      return truckPrice ;
   }
}