import java.util.Enumeration;

public class TextStatement extends Statement {
   
   public String value(Customer aCustomer) {
      Enumeration rentals = aCustomer.getRentals();
      String result = headerString(aCustomer);
      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += eachRentalString(each);
      }
      result += footerString(aCustomer);
      return result;
   }

   private String headerString(Customer aCustomer) {
       return "Rental Record for " + aCustomer.getName() + "\n";
   }

   private String eachRentalString(Rental each) {
       return "\t" + each.getMovie().getTitle()+ "\t" +
       String.valueOf(each.getCharge()) + "\n";
   }

   private String footerString(Customer aCustomer) {
       String result = "Amount owed is " +
       String.valueOf(aCustomer.getTotalCharge()) + "\n";
       result += "You earned " +
       String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
       " frequent renter points";
       return result;
   }
}