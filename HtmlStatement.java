import java.util.Enumeration;

public class HtmlStatement extends Statement {
   
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
       return "<H1>Rentals for <EM>" + aCustomer.getName() +
       "</EM></H1><P>\n";
   }

   private String eachRentalString(Rental each) {
       return each.getMovie().getTitle()+ ": " +
       String.valueOf(each.getCharge()) + "<BR>\n";
   }

   private String footerString(Customer aCustomer) {
       String result = "<P>You owe <EM>" +
       String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
       result += "On this rental you earned <EM>" + 
       String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
       "</EM> frequent renter points<P>";
       return result;
   }
}