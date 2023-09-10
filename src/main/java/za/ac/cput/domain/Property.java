/*
 * Property.java
 * This is the property entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Property {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String propertyID;
    private String address;
    private double rentAmount;
    private String description;


    public Property() {
    }

    private Property(Builder builder) {
        this.propertyID = builder.propertyID;
        this.address = builder.address;
        this.rentAmount = builder.rentAmount;
        this.description = builder.description;

    }

    public String getPropertyID() {
        return propertyID;
    }
    public String getAddress() {
        return address;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Double.compare(property.rentAmount, rentAmount) == 0
                && Objects.equals(propertyID, property.propertyID)
                && Objects.equals(address, property.address)
                && Objects.equals(description, property.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyID, address,
                rentAmount, description);
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyID='" + propertyID + '\'' +
                ", address=" + address +
                ", rent=" + rentAmount +
                ", description=" + description +
                '}';
    }

    //Builder pattern
    public static class Builder{
        private String propertyID;
        private String address;
        private double rentAmount;
        private String description;

        public Builder setPropertyID(String propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setRentAmount(double rentAmount) {
            this.rentAmount = rentAmount;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Property property){
            this.propertyID = property.propertyID;
            this.address = property.address;
            this.rentAmount = property.rentAmount;
            this.description = property.description;
            return this;
        }

        public Property build(){
            return new Property(this); //Anonymous object
        }

    }
}