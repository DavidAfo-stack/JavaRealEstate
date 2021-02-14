package MyRealEstate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;


public class Customer implements Serializable {

    //fields in the customer class
    private static final long serialVersionUID = 1L; // ID generator
    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String presentAddr;
    private String emailAddr;
    private LocalDate dateOfBirth;

    /**
     * parameterized constructor of fields in the customer class
     * @param customerId
     * @param firstName
     * @param lastName
     * @param phoneNo
     * @param presentAddr
     * @param emailAddr
     * @param dateOfBirth
     */
    public Customer(int customerId, String firstName, String lastName, String phoneNo, String presentAddr, String emailAddr, LocalDate dateOfBirth) {
        this.customerId = getRandomId(1000000);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.presentAddr = presentAddr;
        this.emailAddr = emailAddr;
        this.dateOfBirth = dateOfBirth; //LocalDate.of(2017, 10,15);
    }

    /**
     *this method is used to generate random id within a range of predefined values for the customer
     * @param upperBound
     * @return it returns random id for customers
     */
    public static int getRandomId(int upperBound){
        Random randomid = new Random();
        return  randomid.nextInt(upperBound);
    }

    /**
     * getters and setters have been created for the fields in the customer class
     * @return returns each field created in the class
     */
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPresentAddr() {
        return presentAddr;
    }

    public void setPresentAddr(String presentAddr) {
        this.presentAddr = presentAddr;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * to string method created to display specified details of customer
     * @return returns customers details in string format
     */
    @Override
    public String toString() {
        return customerId + "" + " "+ firstName + " " + emailAddr;
        /*return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", presentAddr='" + presentAddr + '\'' +
                ", emailAddr='" + emailAddr + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';*/
    }
}
