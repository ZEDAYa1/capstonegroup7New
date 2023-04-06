package za.ac.cput.domain;

public class PropertyType {
    String apartment;
    String house;
    String townhouse;

    public PropertyType(){

    }
    public PropertyType(String apartment, String house, String townhouse) {
        this.apartment = apartment;
        this.house = house;
        this.townhouse = townhouse;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getTownhouse() {
        return townhouse;
    }

    public void setTownhouse(String townhouse) {
        this.townhouse = townhouse;
    }

    @Override
    public String toString() {
        return "PropertyType{" +
                "apartment='" + apartment + '\'' +
                ", house='" + house + '\'' +
                ", townhouse='" + townhouse + '\'' +
                '}';
    }
}
