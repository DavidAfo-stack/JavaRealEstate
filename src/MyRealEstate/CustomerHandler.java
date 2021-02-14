package MyRealEstate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerHandler {

    public static final long serialVersionUID = 1L; //ID generator

    private static ArrayList<Customer> listOfCustomers; // array list of customer

    /**
     * this method is used to get the list of customers in the database
     * @return returns the list of customers
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Customer> getListOfCustomers() throws IOException, ClassNotFoundException {
        listOfCustomers = (ArrayList<Customer>) HandlerOps.readCustomerFile();
        return listOfCustomers;
    }

    /**
     * This method is used to create a new customer and saves it to the database
     * @param customerId
     * @param firstName
     * @param lastName
     * @param phoneNo
     * @param presentAddr
     * @param emailAddr
     * @param dateOfBirth
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void createCustomer(int customerId, String firstName, String lastName, String phoneNo, String
            presentAddr, String emailAddr, LocalDate dateOfBirth) throws IOException, ClassNotFoundException {
        listOfCustomers = getListOfCustomers();
        Customer customer = new Customer(customerId, firstName, lastName, phoneNo, presentAddr, emailAddr, dateOfBirth);
        listOfCustomers.add(customer);
        HandlerOps.inputDataToCustomerFile(listOfCustomers); // saves customer to database
    }

    /**
     * @return this returns the size of customers in the list
     */
    public int getSize() {
        return listOfCustomers.size();
    }

    /**
     * this method is used to delete customer from the database base by matching the selected customer's ID
     * to the ID in the database
     * uses the removeIf methods in ArrayList to eliminate customer details via customer ID
     * @param customerId
     * @throws IOException
     * @throws ClassNotFoundException
     */
        public static void delete(int customerId) throws IOException, ClassNotFoundException {
            boolean deleteCust;
            deleteCust = getListOfCustomers().removeIf(customer -> customer.getCustomerId() == customerId);
            if(deleteCust){
                HandlerOps.inputDataToCustomerFile(listOfCustomers);
        }
    }
}
