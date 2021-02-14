package MyRealEstate;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class Property implements Serializable {
    //fields in property class
    //private static final long serialVersionUID = 1L;// ID generator
    private int propertyId;
    private String houseType;
    private String location;
    private String postCode;
    private boolean forSale = false;
    private boolean forRent = false;
    private int bedRooms;
    private int bathRooms;
    private boolean hasGarden = false;
    private boolean hasConservatory = false;
    private boolean hasGarage = false;
    private boolean hasLoft = false;
    private double price;
    private LocalDate date;
    private boolean available = false;

    /**
     *  parameterized constructors
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
     */
    public Property(int propertyId, String houseType, String location, String postCode, boolean forSale, boolean forRent, int bedRooms, int bathRooms, boolean hasGarden, boolean hasConservatory, boolean hasGarage, boolean hasLoft, double price, LocalDate date, boolean available) {
        this.propertyId = getRandomId(1000000);
        this.houseType = houseType;
        this.location = location;
        this.postCode = postCode;
        this.forSale = forSale;
        this.forRent = forRent;
        this.bedRooms = bedRooms;
        this.bathRooms = bathRooms;
        this.hasGarden = hasGarden;
        this.hasConservatory = hasConservatory;
        this.hasGarage = hasGarage;
        this.hasLoft = hasLoft;
        this.price = price;
        this.date = date;
        this.available = available;

        //string method for booleans
        String forSaleString = getForSaleString();
        String forRentString = getForRentString();
        String hasGardenString = getHasGardenString();
        String hasGarageString = getHasGarageString();
        String hasConservatoryString = getHasConservatoryString();
        String hasLoftString = getHasLoftString();
        String isAvailableString = getIsAvailableString();
    }

    /**
     *this method is used to generate random id within a range of predefined values for the property
     * @param upperBound
     * @return it returns random id for properties
     */
    public static int getRandomId(int upperBound){
        Random randomid = new Random();
        return  randomid.nextInt(upperBound);

    }

    /**
     * getters and setters for fields in property class
     * @return
     */
    public String getForSaleString() {
        if(forSale){
            return "Yes";
        }
        else{return "No";}
    }

    public String getForRentString() {
        if(forRent){
            return "Yes";
        }
        else{return "No";}
    }

    public String getHasGardenString() {
        if(hasGarden){
            return "Yes";
        }
        else{return "No";}
    }

    public String getHasGarageString() {
        if(hasGarage){
            return "Yes";
        }
        else{return "No";}
    }

    public String getHasConservatoryString() {
        if(hasConservatory){
            return "Yes";
        }
        else{return "No";}
    }

    public String getHasLoftString() {
        if(hasLoft){
            return "Yes";
        }
        else{return "No";}
    }

    public String getIsAvailableString() {
        if(available){
            return "Yes";
        }
        else{return "No";}
    }


    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public boolean isForSale() {

        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
    }

    public int getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(int bedRooms) {
        this.bedRooms = bedRooms;
    }

    public int getBathRooms() {
        return bathRooms;
    }

    public void setBathRooms(int bathRooms) {
        this.bathRooms = bathRooms;
    }

    public boolean isHasGarden() {
        return hasGarden;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public boolean isHasConservatory() {
        return hasConservatory;
    }

    public void setHasConservatory(boolean hasConservatory) {
        this.hasConservatory = hasConservatory;
    }

    public boolean isHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public boolean isHasLoft() {
        return hasLoft;
    }

    public void setHasLoft(boolean hasLoft) {
        this.hasLoft = hasLoft;
    }

    public double getPrice() {
        DecimalFormat formatter = new DecimalFormat("00.00");
        return Double.parseDouble(formatter.format(price));
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * toString method displaying all feilds in the property class as string
     * @return
     */
    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", houseType='" + houseType + '\'' +
                ", location='" + location + '\'' +
                ", postCode='" + postCode + '\'' +
                ", forSale=" + forSale +
                ", forRent=" + forRent +
                ", bedRooms=" + bedRooms +
                ", bathRooms=" + bathRooms +
                ", hasGarden=" + hasGarden +
                ", hasConservatory=" + hasConservatory +
                ", hasGarage=" + hasGarage +
                ", hasLoft=" + hasLoft +
                ", price=" + price +
                ", date=" + date +
                ", available=" + available +
                '}';
    }
}
