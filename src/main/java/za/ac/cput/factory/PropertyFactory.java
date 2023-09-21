/*
* PropertyFactory.java
* Tshegofatso Molefe
* 219001235
* Date: 6 April 2023
* */
package za.ac.cput.factory;

import za.ac.cput.domain.Property;
import za.ac.cput.util.Helper;

public class PropertyFactory {
    public static Property createProperty(String address, double rentAmount,
                                          String description) {
        if (Helper.isNullOrEmpty(String.valueOf(address))
                || Helper.isNullOrEmpty(String.valueOf(rentAmount))
                || Helper.isNullOrEmpty(String.valueOf(description))) {
            return null;
        }


        String propertyId = Helper.generateId();

        Property property = new Property.Builder()
                .setPropertyId(propertyId)
                .setAddress(address)
                .setRentAmount(rentAmount)
                .setDescription(description)
                .build();
        return property;
    }
}