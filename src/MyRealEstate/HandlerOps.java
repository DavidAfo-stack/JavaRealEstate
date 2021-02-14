package MyRealEstate;

import java.io.*;
import java.util.ArrayList;

public class HandlerOps {

    /**
     * initialize different files where customers, properties and invoices will be saved
     */
    private static String customerFile = "CustomersList.dat";
    private static String propertyFile = "PropertiesList.dat";
    private static String invoiceFile = "Invoice.dat";

    /**
     *this method uses FilOutputStream and ObjectOutputStream to write to the customer file
     * @param custList
     * @throws IOException
     * Reference: Lecture Notes
     * Tutor: Dr. Suraj Ajit
     */
    public static void inputDataToCustomerFile(ArrayList<Customer> custList) throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(customerFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(custList);
            objOut.flush();
            objOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * this uses FileInputStream and ObjectInputStream to deserialize the customers list i.e to read from customer database
     * @return returns the list of customers in the database
     * @throws IOException
     * @throws ClassNotFoundException
     * Reference: Lecture Notes
     * Tutor: Dr. Suraj Ajit
     */
    public static ArrayList<Customer> readCustomerFile() throws IOException, ClassNotFoundException {
        ArrayList<Customer> listOfCustomers = new ArrayList<Customer>();
        try {
            File f = new File(customerFile);
            FileInputStream inStream;
            ObjectInputStream objInput = null;
            if (f.exists()) {
                inStream = new FileInputStream(customerFile);
                objInput = new ObjectInputStream(inStream);
            } else {
                System.out.println("File " + customerFile + " does not exist");
                return listOfCustomers;
            }
            if (f.length() > 0) {
                // Reads the serialized objects from the customer file.
                listOfCustomers = (ArrayList<Customer>) objInput.readObject();

                // Close the file.
                objInput.close();
                inStream.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }

        return listOfCustomers;
    }


    /**
     * this method uses FilOutputStream and ObjectOutputStream to write to the property file
     * @param propertyList
     * @throws IOException
     * Reference: Lecture Noted
     * Tutor: Dr Suraj Ajit
     */
    public static void inputDataToPropertyFile(ArrayList<Property> propertyList) throws IOException {

        try {
            FileOutputStream fileOut = new FileOutputStream(propertyFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(propertyList);
            objOut.flush();
            objOut.close();


        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * this uses FileInputStream and ObjectInputStream to deserialize the property list i.e to read from property database
     * @return returns list of properties in the database
     * @throws IOException
     * @throws ClassNotFoundException
     * Reference: Lecture Notes
     * Tutor: Dr. Suraj Ajit
     */
    public static ArrayList<Property> readPropertyFile() throws IOException, ClassNotFoundException {
        ArrayList<Property> listOfProperties = new ArrayList<>();
        try {
            File f = new File(propertyFile);
            FileInputStream inStream;
            ObjectInputStream obj;
            if (f.exists()) {
                inStream = new FileInputStream(propertyFile);
                obj = new ObjectInputStream(inStream);
            } else {
                System.out.println("File " + propertyFile + " does not exist");
                return listOfProperties;
            }

            if (f.length() > 0) {
                // Read the serialized objects from the file.
                listOfProperties = (ArrayList<Property>) obj.readObject();
                //System.out.println("read object");
                // Close the file.
                obj.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        return listOfProperties;
    }

    /**
     * this method uses FilOutputStream and ObjectOutputStream to write to the invoice file
     * @param invoices
     * @throws IOException
     * Reference: Lecture Notes
     * Tutor: Dr. Suraj Ajit
     */
    public static void inputDataToInvoiceFile(ArrayList<Invoice> invoices) throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(invoiceFile);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(invoices);
            objOut.flush();
            objOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    /**
     *this uses FileInputStream and ObjectInputStream to deserialize the invoice list i.e to read from invoice database
     * @return returns list of invoices in the databases
     * @throws IOException
     * @throws ClassNotFoundException
     * Reference: Lecture Notes
     * Tutor: Dr. Suraj Ajit
     */
    public static ArrayList<Invoice> readInvoiceFile() throws IOException, ClassNotFoundException {
        ArrayList<Invoice> list = new ArrayList<>();
        try {
            File f = new File(invoiceFile);
            FileInputStream inStream = null;
            ObjectInputStream objInput = null;
            if (f.exists()) {
                inStream = new FileInputStream(invoiceFile);
                objInput = new ObjectInputStream(inStream);
            }

            if (f.length() > 0) {
                // Read the serialized objects from invoice file.
                list = (ArrayList<Invoice>) objInput.readObject();
                // Close the file.
                objInput.close();
                inStream.close();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }

        return list;
    }
}

