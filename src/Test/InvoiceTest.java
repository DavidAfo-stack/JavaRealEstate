package Test;

import MyRealEstate.Customer;
import MyRealEstate.Invoice;
import MyRealEstate.InvoiceHandler;
import MyRealEstate.Property;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceTest {
    private Customer customer;
    private Property property;
    private Invoice invoice;
    private InvoiceHandler invoiceHandler;


    @Test
    void getAgentFee() throws IOException, ClassNotFoundException {
        /*Customer customer= new Customer(Customer.getRandomId(1000000), "John", "Bravo", "098487422432",
                "2, Kettering Road, Northampton", "john@email.com", LocalDate.of(12, 1, 1));
        Property property = new Property(Property.getRandomId(1000000), "Detached", "Northampton",
                "NN3 8IJ", true, false, 3, 3, true, false, false,
                false, 400, LocalDate.of(12, 1, 1), true);
        Invoice invoice = InvoiceHandler.createInvoice( customer, property);
        assertEquals(6.0, invoice.getAgentFee());*/
    }


    @Test
    void getRentDeposit() throws IOException, ClassNotFoundException {
       Customer customer= new Customer(Customer.getRandomId(1000000), "John", "Bravo", "098487422432",
             "2, Kettering Road, Northampton", "john@email.com", LocalDate.of(12, 1, 1));
    Property property = new Property(Property.getRandomId(1000000), "Detached", "Northampton",
                "NN3 8IJ", false, true, 3, 3, true, false, false,
                false, 500, LocalDate.of(12, 1, 1), true);
        Invoice invoice = InvoiceHandler.createInvoice( customer, property);
        assertEquals(1700, invoice.getRentDeposit());
    }
}