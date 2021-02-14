package MyRealEstate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InvoiceRecordsController implements Initializable {
    //fields generated from java fx scene builder
    @FXML
    private Button homebtn;

    @FXML
    private TableView<Invoice> invoiceTable;

    @FXML
    private TableColumn<Invoice, Integer> invoiceId;

    @FXML
    private TableColumn<Invoice, String> customerFirstName;

    @FXML
    private TableColumn<Invoice, String> customerLastName;

    @FXML
    private TableColumn<Invoice, String> propertyLocation;

    @FXML
    private TableColumn<Invoice, String> propertypostCode;

    @FXML
    private TableColumn<Invoice, Double> propertyPrice;

    @FXML
    private TableColumn<Invoice, Double> propertyAgentFee;

    @FXML
    private TableColumn<Invoice, Double> propertyDeposit;

    @FXML
    private TableColumn<Invoice, Double> propertyTotalFee;

    @FXML
    private TableColumn<Invoice, LocalDate> date;

    @FXML
    private TableColumn<Invoice, String> nextRentDate;

    @FXML
    private Button deleteRecoredBtn;

    private Customer customer;

    private Invoice invoice;

    /**
     * Array list of invoice is the database is cast into an array list of the invoice table
     * show the payment records saved in the database and wrapping it with an observable list
     * to track changes in the list
     */
    ArrayList<Invoice> list;

    {
        try {
            list = new ArrayList<Invoice>((ArrayList<Invoice>) InvoiceHandler.getInvoiceList());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ObservableList<Invoice> invoiceList = FXCollections.observableList(list);

    /**
     * in the intialize method, cell value factory is being set, matching fields in the invoice class to the invoice table
     * the values of the matched fields will thus be displayed on the table view
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        invoiceId.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("invoiceId"));
        customerFirstName.setCellValueFactory(new PropertyValueFactory<Invoice, String>("customerFirstName"));
        customerLastName.setCellValueFactory(new PropertyValueFactory<Invoice, String>("customerLastName"));
        propertyLocation.setCellValueFactory(new PropertyValueFactory<Invoice, String>("propertyLocation"));
        propertypostCode.setCellValueFactory(new PropertyValueFactory<Invoice, String>("propertyPostCode"));
        propertyPrice.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("propertyPrice"));
        propertyAgentFee.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("agentFee"));
        propertyDeposit.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("rentDeposit"));
        propertyTotalFee.setCellValueFactory(new PropertyValueFactory<Invoice, Double>("totalFee"));
        date.setCellValueFactory(new PropertyValueFactory<Invoice, LocalDate>("date"));
        nextRentDate.setCellValueFactory(new PropertyValueFactory<Invoice, String>("nextRent"));

        //set items on table
        invoiceTable.setItems(invoiceList);
        // set table selection model
        invoiceTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /**
     * this method controls the home button which navigates the user back to the home page
     * this uses FXMLLoader to get the url of the home page and then set
     * the scene to the home page
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void homebtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * this method deletes payment record from both table view and database completely
     * @param actionEvent
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void deleteRecordBtnListener(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        //delete Invoice from table
        Invoice invoice = invoiceTable.getSelectionModel().getSelectedItem();
        int row = invoiceTable.getSelectionModel().getSelectedIndex();
        delete(row);

        //delete Invoice from serialized database
        if(invoice != null) {
            InvoiceHandler.delete(invoice.getInvoiceId());
        }
    }

    /**
     * the selected row is deleted from table view
     * @param row
     */
    public void delete(int row){
        if(row >= 0){
            invoiceTable.getItems().remove(row);
        }

    }
}
