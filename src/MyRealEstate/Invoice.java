package MyRealEstate;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Invoice implements Serializable{
    // fields in the invoice class
   // private static final long serialVersionUID = 1L; //ID generator
    private int invoiceId;
    private Customer customer;
    private Property property;
    private double agentFee;
    private double rentDeposit;
    private LocalDate date;
    private LocalDate nextRentDueDate;
    private double totalFee;

    /**
     * constructor method for the invoice class
     * this method makes use of parameters from the customer and property class
     * @param customer
     * @param property
     */
    public Invoice( Customer customer, Property property) {
        this.invoiceId = getRandomId(1000000);
        this.customer = customer;
        this.property = property;
        this.agentFee = getAgentFee();
        this.rentDeposit = getRentDeposit();
        this.date = LocalDate.now();
        this.nextRentDueDate = getNextRentDueDate();
        this.totalFee = getTotalFee();

        // get string values of fields in property and customer class
        String customerFirstName = getCustomerFirstName();
        String customerLastName = getCustomerLastName();
        String propertyLocation = getPropertyLocation();
        String propertyPostCode = getPropertyPostCode();
        double propertyPrice = getPropertyPrice();
        String nextRent = getNextRent();
    }

    /**
     *this method is used to generate random id within a range of predefined values for the invoice
     * @param upperBound
     * @return it returns random id for invoice
     */
    public static int getRandomId(int upperBound){
        Random randomid = new Random();
        return  randomid.nextInt(upperBound);

    }

    /**
     * getters and setters for invoice fields
     * @return returns the set values for each field
     */
    public double getPropertyPrice(){
        return property.getPrice();
    }

    public String getPropertyLocation(){
        return property.getLocation();
    }

    public String getCustomerLastName(){
        return customer.getLastName();
    }

    public String getCustomerFirstName(){
        return customer.getFirstName();
    }

    public String getPropertyPostCode(){
        return property.getPostCode();
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    /**
     * this method implies that if the property is for sale then 1.5% of the price is the agent fee
     * if it is for rent, then agent fee is 300
     * @return returns agent fee
     */
    public double getAgentFee() {

        if(property.isForSale()){
           agentFee = 0.015 * property.getPrice();
        } else{agentFee = 300;}

        return agentFee;
    }

    public void setAgentFee(double agentFee) {
        this.agentFee = agentFee;
    }

    /**
     * this method implies that if the property is for rent then the rent deposit will be 3 times the rent price
     * @return returns the rent deposit
     */
    public double getRentDeposit() {
        if(property.isForRent()){
            rentDeposit = 3 * property.getPrice();
        }
        else{rentDeposit = 0;}

        return rentDeposit;
    }

    public void setRentDeposit(double rentDeposit) {
        this.rentDeposit = rentDeposit;
    }

    public String getDate() {
        return dateStringFormatter(date);
    }

    /**
     * this method converts date to string format
     * @param date
     * @return
     */
    public String dateStringFormatter(LocalDate date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, YYYY");
       return  dateTimeFormatter.format(date);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // sets a string value if the property is not for rent
    public String getNextRent(){
        if(nextRentDueDate == null){
            return "Not Applicable";
        } else {
            return dateStringFormatter(date.plusMonths(1));
        }

    }

    public LocalDate getNextRentDueDate() {
        if (property.isForSale()){
            return null;
        }
        else {
            nextRentDueDate = date.plusMonths(1);
        }
       return nextRentDueDate;
    }

    public void setNextRentDueDate(LocalDate nextRentDueDate) {
        this.nextRentDueDate = nextRentDueDate;
    }

    public double getTotalFee() {
        return totalFee = agentFee + rentDeposit + property.getPrice();

    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * this method returns string format of fields in the invoice class
     * @return
     */
    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", customer=" + customer +
                ", property=" + property +
                ", agentFee=" + agentFee +
                ", rentDeposit=" + rentDeposit +
                ", date=" + getDate() +
                ", nextRentDueDate=" + getNextRent() +
                ", totalFee=" + totalFee +
                '}';
    }
}
