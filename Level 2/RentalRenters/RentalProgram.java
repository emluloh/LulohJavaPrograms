// Renter Rentals - Java 5B
// Eileen Luloh - Sum '23


public class RentalProgram
{
   public static void main(String [] args)
   {
      Rental renter1 = new Rental();
      renter1.setRenterName("DANIEL MAVRIDIS");
      renter1.setPropertyAddress("3652 DELL DR.");
      renter1.setCityStateZip("DENTON, TX 76210");
      renter1.setNumBedrooms(4);
      renter1.setNumBathrooms(2.5);
      renter1.setSquareFeet(2815);
   
      Rental renter2 = new Rental("PAUL JUAREZ");
      renter2.setPropertyAddress("1563 GATEWAY BLVD");
      renter2.setCityStateZip("LEWISVILLE, TX 76067");
      renter2.setNumBedrooms(5);
      renter2.setNumBathrooms(3);
      renter2.setSquareFeet(3115);
      
      Rental renter3 = new Rental("LINDA TERRAZAS", "3101 COMPAQ CIR", "FRISCO, TX 77023", 3, 2, 2120);
      
      printRentalInfo(renter1);
      printRentalInfo(renter2);
      printRentalInfo(renter3);
         
   }
   
   // The printRentalInfo method does the same thing as writing out renter1.getWhateverInfo();, 
   // renter2.getWhateverInfo();, etc., but passes renter1 as an argument into the renter parameter, 
   // prints it, passes renter2 as an argument into the renter parameter, prints that, etc.
   // TLDR Rental renter param accepts a Rental object as an arg, doesn't create a new Rental object
   private static void printRentalInfo(Rental renter)
   {
      System.out.println("Renter: " + renter.getRenterName());
      System.out.println("Address: " + renter.getPropertyAddress());
      System.out.println("City, State, Zip: " + renter.getCityStateZip());
      System.out.println("Bedrooms: " + renter.getNumBedrooms());
      System.out.println("Baths: " + renter.getNumBathrooms());
      System.out.println(String.format("Square Feet: %,.2f", renter.getSquareFeet()));
      System.out.println(String.format("Rental Price: $%,.2f%n", renter.getRentalPrice()));
   }
}
