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
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class addPropertyController<propertyTypes> implements Initializable {
    // fields generated from java fx scene builder
    @FXML
    private Label propertyTypeLabel;

    @FXML
    private ComboBox<String> propertyTypeMenu;

    @FXML
    private Label locationLabel;

    @FXML
    private Label postCodeLabel;

    @FXML
    private Label propertyStatusLabel;

    @FXML
    private Label bedRoomToolTip;

    @FXML
    private Label bathRoomToolTip;

    @FXML
    private Label addFeaturesLabel;

    @FXML
    private Label bedRoomLabel;

    @FXML
    private TextArea locationField;

    @FXML
    private TextField postCodeField;

    @FXML
    private Label bathroomLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Button submitButton;

    @FXML
    private Button homeBtn;

    @FXML
    private Button displayProperties;

    @FXML
    private ToggleGroup propStatus;

    @FXML
    private TextField priceField;

    @FXML
    private TextField bedRoomField;

    @FXML
    private TextField bathRoomField;

    @FXML
    private RadioButton propertySellBtn;

    @FXML
    private RadioButton propertyRentBtn;

    @FXML
    private CheckBox gardenBtn;

    @FXML
    private CheckBox conservatoryBtn;

    @FXML
    private CheckBox garageBtn;

    @FXML
    private CheckBox loftBtn;

    @FXML
    private DatePicker dateField;

    @FXML
    private CheckBox availableBtn;

    private Property property; //property class
    private ArrayList<Property> listOfProperties; // array list of properties

    /**
     * an observable list that contains the types of properties to be displayed in the combobox
     */
    ObservableList<String> propertyTypes = FXCollections.observableArrayList("Detached", "Semi-Detached", "Bungalow", "Terraced", "Flat");

    /**
     * this initialize method sets the types of properties in the observable list into the combo box
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        propertyTypeMenu.setValue("Select a Property Type");
        propertyTypeMenu.setItems(propertyTypes);
    }

    /**
     * this method is used to control the submit button which validates all fields on the property registration page
     * then saves it to the database
     * @param actionEvent
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    public void submitButtonListener(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if(actionEvent.getSource() == submitButton) {
            String propertyType = propertyTypeMenu.getValue();
            String location = locationField.getText();
            String postcode = postCodeField.getText();
            boolean forSale = propertySellBtn.isSelected();
            boolean forRent = propertyRentBtn.isSelected();
            String bedRooms = bedRoomField.getText();
            String bathRooms =  bathRoomField.getText();
            boolean hasGarden = gardenBtn.isSelected();
            boolean hasConservatory = conservatoryBtn.isSelected();
            boolean hasGarage = garageBtn.isSelected();
            boolean hasLoft = loftBtn.isSelected();
            String price = priceField.getText();
            LocalDate date = dateField.getValue();
            boolean available = availableBtn.isSelected();

            if (propertyTypeMenu.getSelectionModel().getSelectedIndex()<0) {
                String msg = "Please Select a Property Type";
                JOptionPane.showMessageDialog(null, msg);
            }
            else if (locationField.getText().isEmpty()) {
                String msg = "Please enter property location";
                JOptionPane.showMessageDialog(null, msg);

            } else if (postCodeField.getText().isEmpty()) {
                String msg = "Please enter property postcode";
                JOptionPane.showMessageDialog(null, msg);
            }
            else if (bedRoomField.getText().isEmpty()) {
                String msg = "Please enter number of bedroom";
                JOptionPane.showMessageDialog(null, msg);
            }
            else  if(Integer.parseInt(bedRoomField.getText()) > 5){
                String msg = "Maximum number of bedroom is 5";
                JOptionPane.showMessageDialog(null, msg);
            }
            else if (bathRoomField.getText().isEmpty()) {
                String msg = "Please enter number of bathroom";
                JOptionPane.showMessageDialog(null, msg);
            }
            else  if(Integer.parseInt(bathRoomField.getText()) > 5){
                String msg = "Maximum number of bathroom is 5";
                JOptionPane.showMessageDialog(null, msg);
            }
            else if (priceField.getText().isEmpty()) {
                String msg = "Please enter price";
                JOptionPane.showMessageDialog(null, msg);
            }
            else if (dateField.getEditor().getText().isEmpty()){
                String msg = "Please choose date of entry";
                JOptionPane.showMessageDialog(null, msg);
            }
            else{
                property = new Property(Property.getRandomId(1000000), propertyTypeMenu.getValue(), locationField.getText(),
                        postCodeField.getText(), propertySellBtn.isSelected(), propertyRentBtn.isSelected(),
                        Integer.parseInt(bedRoomField.getText()), Integer.parseInt(bathRoomField.getText()), gardenBtn.isSelected(),
                        conservatoryBtn.isSelected(), garageBtn.isSelected(), loftBtn.isSelected(), Integer.parseInt(priceField.getText()),
                        dateField.getValue(), availableBtn.isSelected());
                listOfProperties = PropertyHandler.getListOfProperties();
                listOfProperties.add(property);
                propertyTypeMenu.getValue();
                locationField.setText("");
                postCodeField.setText("");
                bedRoomField.setText("");
                bathRoomField.setText("");
                priceField.setText("");
                dateField.getValue();

                if(propertySellBtn.isSelected()){
                    property.setForSale(true);
                } else if(propertyRentBtn.isSelected()){
                    property.setForRent(true);
                }

                if(garageBtn.isSelected()){
                    property.setHasGarden(true);
                } else{property.setHasGarden(false);}

                if(conservatoryBtn.isSelected()){
                    property.setHasConservatory(true);
                } else{property.setHasConservatory(false);}

                if(gardenBtn.isSelected()){
                    property.setHasGarden(true);
                } else{property.setHasGarden(false);}

                if(loftBtn.isSelected()){
                    property.setHasLoft(true);
                }else{property.setHasLoft(false);}

                if(availableBtn.isSelected()){
                    property.setAvailable(true);
                }else{property.setAvailable(false);}

                HandlerOps.inputDataToPropertyFile(listOfProperties); // saves file to database
                String outputMsg = "Property Entry Approved!";
                JOptionPane.showMessageDialog(null, outputMsg);
            }
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
    public void homeBtnListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Index.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * this method is used to control a button that shows the list of properties in the database
     * it uses FXMLLoader to get the url of the page containing list of properties in the database
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void displayPropertiesListener(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("propertyListPage.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("List Of Properties");
        stage.setScene(scene);
        stage.show();
    }
}
