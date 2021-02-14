package MyRealEstate;

import java.io.IOException;
import java.util.ArrayList;

public class InvoiceHandler {
    public static final long serialVersionUID = 1L; // ID generator

    private static ArrayList<Invoice> invoiceList;

    /**
     * gets the invoices  that are saved in the database
     * @return returns invoices in database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Invoice> getInvoiceList() throws IOException, ClassNotFoundException {
        invoiceList = (ArrayList<Invoice>) HandlerOps.readInvoiceFile();
        return invoiceList;
    }

    /**
     * creates a new invoice and saves it to the database
     * @param customer
     * @param property
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Invoice createInvoice(Customer customer, Property property) throws IOException, ClassNotFoundException {
        invoiceList = getInvoiceList();
        Invoice invoice = new Invoice(customer, property);
        invoiceList.add(invoice);
        HandlerOps.inputDataToInvoiceFile(invoiceList);
        return invoice;
    }

    /**
     * gets the size of the invoice in the database
     * @return
     */
    public int getSize() {
        return invoiceList.size();
    }

    /**
     * this method is used to delete invoice from the database
     * uses the removeIf methods in ArrayList to eliminate payment details via invoice ID
     * @param invoiceId
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void delete(int invoiceId) throws IOException, ClassNotFoundException {
        boolean deleteRecord;
        deleteRecord = getInvoiceList().removeIf(invoice -> invoice.getInvoiceId() == invoiceId);
        if(deleteRecord){
            HandlerOps.inputDataToInvoiceFile(invoiceList);
        }
    }
}
