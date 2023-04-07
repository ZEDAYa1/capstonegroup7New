/*
 * Property.java
 * This is the property entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.domain;

import java.util.Objects;

public class Property {
    private String propertyID;
    private PropertyType propertyType;
    private Address address;
    private double rent;
    private int bedsNum;
    private int bathsNum;
    private boolean garageAvailable;


//    public Property() {
//    }

    private Property(Builder builder) {
        this.propertyID = builder.propertyID;
        this.propertyType = builder.propertyType;
        this.address = builder.address;
        this.rent = builder.rent;
        this.bedsNum = builder.bedsNum;
        this.bathsNum = builder.bathsNum;
        this.garageAvailable = builder.garageAvailable;
    }

    public String getPropertyID() {
        return propertyID;
    }
    public PropertyType getPropertyType() {
        return propertyType;
    }
    public Address getAddress() {
        return address;
    }
    public double getRent() {
        return rent;
    }
    public int getBedsNum() {
        return bedsNum;
    }
    public int getBathsNum() {
        return bathsNum;
    }
    public boolean isGarageAvailable() {
        return garageAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.rent, rent) == 0 && bedsNum == property.bedsNum
                && bathsNum == property.bathsNum && garageAvailable == property.garageAvailable
                && Objects.equals(propertyID, property.propertyID)
                && Objects.equals(propertyType, property.propertyType)
                && Objects.equals(address, property.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyID, propertyType, address,
                rent, bedsNum, bathsNum, garageAvailable);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyID='" + propertyID + '\'' +
                ", propertyType=" + propertyType +
                ", address=" + address +
                ", rent=" + rent +
                ", bedsNum=" + bedsNum +
                ", bathsNum=" + bathsNum +
                ", garageAvailable=" + garageAvailable +
                '}';
    }

    //Builder pattern
    public static class Builder{
        private String propertyID;
        private Address address;
        private PropertyType propertyType;
        private double rent;
        private int bedsNum, bathsNum;
        private boolean garageAvailable;

        public Builder setPropertyID(String propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setPropertyType(PropertyType propertyType) {
            this.propertyType = propertyType;
            return this;
        }

        public Builder setRent(double rent) {
            this.rent = rent;
            return this;
        }

        public Builder setBedsNum(int bedsNum) {
            this.bedsNum = bedsNum;
            return this;
        }

        public Builder setBathsNum(int bathsNum) {
            this.bathsNum = bathsNum;
            return this;
        }

        public Builder setGarageAvailable(boolean garageAvailable) {
            this.garageAvailable = garageAvailable;
            return this;
        }

        public Builder copy(Property property){
            this.propertyID = property.propertyID;
            this.address = property.address;
            this.propertyType = property.propertyType;
            this.rent = property.rent;
            this.bedsNum = property.bedsNum;
            this.bathsNum = property.bathsNum;
            this.garageAvailable = property.garageAvailable;
            return this;
        }

        public Property build(){
            return new Property(this); //Anonymous object
        }

    }
}