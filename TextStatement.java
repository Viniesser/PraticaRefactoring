public class TextStatement extends Statement {
   
   protected String headerString(Customer aCustomer) {
       return "Rental Record for " + aCustomer.getName() + "\n";
   }

   protected String eachRentalString(Rental each) {
       return "\t" + each.getMovie().getTitle()+ "\t" +
       String.valueOf(each.getCharge()) + "\n";
   }

   protected String footerString(Customer aCustomer) {
       String result = "Amount owed is " +
       String.valueOf(aCustomer.getTotalCharge()) + "\n";
       result += "You earned " +
       String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
       " frequent renter points";
       return result;
   }
}