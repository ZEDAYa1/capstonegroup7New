/*
* PropertyFactory.java
* Tshegofatso Molefe
* 219001235
* Date: 6 April 2023
* */
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Property;
import za.ac.cput.domain.PropertyType;
import za.ac.cput.util.Helper;

public class PropertyFactory {
    public static Property createProperty(PropertyType propertyType, Address address,
                                          double rent, int bedsNum, int bathsNum, boolean garageAvailable) {
        if (Helper.isNullOrEmpty(String.valueOf(propertyType)) || Helper.isNullOrEmpty(String.valueOf(address))
                || Helper.isNullOrEmpty(String.valueOf(rent))
                || Helper.isNullOrEmpty(String.valueOf(bedsNum))
                || Helper.isNullOrEmpty(String.valueOf(bathsNum))
                || Helper.isNullOrEmpty(String.valueOf(garageAvailable))) {
            return null;
        }


        String propertyID = Helper.generateId();

        Property property = new Property.Builder().setPropertyID(propertyID)
                .setPropertyType(new PropertyType())
                .setAddress(new Address())
                .build();
        return property;

    }
}