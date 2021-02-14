package MyRealEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;

public class HomeIndexController {
    // fields generated from java fx scene builder
    public javafx.scene.control.Button propertyBtn;
    public javafx.scene.control.Button customerBtn;
    @FXML
    private AnchorPane homePageImage;

    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button addPropertyBtn;

    /**
     *this method is used to control a button that shows the list of customers in the database
     *it uses FXMLLoader to get the url of the page containing customer registration form
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void addCustomerBtnListener(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addCustomerPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Customer Registration");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *this method is used to control a button that navigates to the property registration
     *it uses FXMLLoader to get the url of the page containing property registration form
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void addPropertyBtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("addPropertyPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Property Registration");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *this method is used to control a button that shows the list of customers in the database
     * it uses FXMLLoader to get the url of the page containing list of customers in the database
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void showCustomerBtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("customersListPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Customers");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *this method is used to control a button that shows the list of properties in the database
     *it uses FXMLLoader to get the url of the page containing list of properties in the database
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void showPropertiesBtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("propertyListPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("List Of Properties");
        stage.setScene(scene);
        stage.show();
    }

    /**
     *this method is used to control a button that shows invoices in the database on a table view
     *it uses FXMLLoader to get the url of the page containing invoices in the database
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void showInvoicesBtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("InvoiceRecords.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Invoices");
        stage.setScene(scene);
        stage.show();
    }
}
