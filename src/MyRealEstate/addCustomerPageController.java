package MyRealEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static javafx.application.Application.launch;


public class addCustomerPageController{
    // fields generated from java fx scene builder
    public javafx.scene.control.Button customerSubmitButton;
    public TextArea CustomersDisplay;

    @FXML
    private Label firstNameLabel;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField phoneNoField;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label presentAddrLabel;

    @FXML
    private Label phoneNoLabel;

    @FXML
    private TextArea presentAddrField;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailField;

    @FXML
    private Label dobLabel;

    @FXML
    private DatePicker dobField;

    @FXML
    private Button homeBtn;

    @FXML
    private Button showCustomerBtn;

    @FXML
    private Button goToPropBtn;

    private Customer customer;
    private ArrayList<Customer> listOfCustomers;


    /**
     * the customer submit button is used to save customer details
     * it checks if every detail in the field is computed and validates the form
     * the form is saved to database via serialization
     * @param actionEvent
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    public void customerSubmitBtnListener (ActionEvent actionEvent) throws IOException, ClassNotFoundException {

         if (actionEvent.getSource() == customerSubmitButton) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNo = phoneNoField.getText();
                String presentAddr = presentAddrField.getText();
                String emailAddr = emailField.getText();
                LocalDate dateOfBirth = dobField.getValue();

                if (firstNameField.getText().isEmpty()) {
                    String msg = "Please enter first name";
                    JOptionPane.showMessageDialog(null,msg);
                } else if(lastNameField.getText().isEmpty()){
                    String msg = "Please enter last name";
                    JOptionPane.showMessageDialog(null,msg);
                }else if(phoneNoField.getText().isEmpty()){
                    String msg = "Please enter phone number";
                    JOptionPane.showMessageDialog(null,msg);
                }
                else if(presentAddrField.getText().isEmpty()){
                    String msg = "Please enter present address";
                    JOptionPane.showMessageDialog(null,msg);
                }
                else if(emailField.getText().isEmpty()){
                    String msg = "Please enter email address";
                    JOptionPane.showMessageDialog(null,msg);
                }
                else if(dobField.getEditor().getText().isEmpty()){
                    String msg = "Please enter date of birth";
                    JOptionPane.showMessageDialog(null,msg);
                }
                else {
                customer = new Customer(Customer.getRandomId(1000000), firstNameField.getText(),
                        lastNameField.getText(), phoneNoField.getText(), presentAddrField.getText(),
                        emailField.getText(), dobField.getValue());
                listOfCustomers = CustomerHandler.getListOfCustomers();
                listOfCustomers.add(customer);
                firstNameField.setText("");
                lastNameField.setText("");
                phoneNoField.setText("");
                presentAddrField.setText("");
                emailField.setText("");
                dobField.show();
                String outputMsg = "Customer Entry Approved!";
                JOptionPane.showMessageDialog(null, outputMsg);
                // saves file to database
                HandlerOps.inputDataToCustomerFile(listOfCustomers);  }
        }
    }

    /**
     * this method controls the home button which navigates the user back to the home page
     * this uses FXMLLoader to get the url of the home page and then set
     * the scene to the home page
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void homeBtnListener (ActionEvent actionEvent) throws IOException {
            Parent parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Home");
            stage.setScene(scene);
            stage.show();
    }

    /**
     * this method is used to control a button that shows the list of customers in the database
     * it uses FXMLLoader to get the url of the page containing list of customers in the database
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void showCustomerBtnListener(ActionEvent actionEvent) throws IOException {
            if(actionEvent.getSource() == showCustomerBtn){
                Parent parent = FXMLLoader.load(getClass().getResource("customersListPage.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setTitle("Customers");
                stage.setScene(scene);
                stage.show();
            }

    }

    /**
     * this method is used to control a button that navigates to the page displaying list of properties for sale/rent
     * this method makes use of FXMLLoader to get the url and displays the page of the list of properties
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void goToPropBtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("propertyListPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("List Of Customers");
        stage.setScene(scene);
        stage.show();
    }
}



