package MyRealEstate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static MyRealEstate.HandlerOps.inputDataToPropertyFile;

public class PropertyHandler {
    public static final long serialVersionUID = 1L;// ID generator

    private static ArrayList<Property> listOfProperties;// ArrayList of properties

    //gets the size of the array list
    public int getSize() {
        return this.listOfProperties.size();
    }

    /**
     * this method gets the list of properties from the database
     * @return returns all properties recorded in the database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Property> getListOfProperties() throws IOException, ClassNotFoundException {
        listOfProperties = HandlerOps.readPropertyFile();
        return listOfProperties;

    }

    /**
     * this method is used to create a new property and saves it to the database
     * @param propertyId
     * @param houseType
     * @param location
     * @param postCode
     * @param forSale
     * @param forRent
     * @param bedRooms
     * @param bathRooms
     * @param hasGarden
     * @param hasConservatory
     * @param hasGarage
     * @param hasLoft
     * @param price
     * @param date
     * @param available
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void createProperty(int propertyId, String houseType, String location, String postCode, boolean forSale, boolean forRent, int bedRooms, int bathRooms, boolean hasGarden, boolean hasConservatory, boolean hasGarage, boolean hasLoft, double price, LocalDate date, boolean available) throws IOException, ClassNotFoundException {
        listOfProperties = getListOfProperties();
        Property property = new Property(propertyId, houseType, location, postCode, forSale, forRent, bedRooms , bathRooms, hasGarden, hasConservatory, hasGarage, hasLoft, price, date, available);
        listOfProperties.add(property);
        inputDataToPropertyFile(listOfProperties);
    }

    /**
     * this method uses the removeIf methods in ArrayList to eliminate property details via property ID
     * @param propertyId
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void delete(int propertyId) throws IOException, ClassNotFoundException {
        boolean deleteProp;
        deleteProp = getListOfProperties().removeIf(property -> property.getPropertyId() == propertyId);
            if(deleteProp){
                HandlerOps.inputDataToPropertyFile(listOfProperties);
            }
    }

    /**
     * check if the property purchased is the same as the property in the database via property ID
     *so as to set the availability to false
     * @param propertyId
     * @param status
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void setAvailabilityStatus(int propertyId, boolean status) throws IOException, ClassNotFoundException {
        listOfProperties = getListOfProperties();
        for(int i=0; i<=listOfProperties.size() - 1 ; i++){
            Property property = listOfProperties.get(i);
            if(property.getPropertyId() == propertyId){
                property.setAvailable(status);
            }
        }
        HandlerOps.inputDataToPropertyFile(listOfProperties);
    }
}
