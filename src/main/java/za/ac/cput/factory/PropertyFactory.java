package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Property;
import za.ac.cput.domain.PropertyType;
import za.ac.cput.util.Helper;

public class PropertyFactory {
    public static Property createProperty(String propertyID, PropertyType propertyType, Address address,
                                          double rent, int bedsNum, int bathsNum, boolean garageAvailable) {
        return null;
    }

    String propertyID = Helper.generateId();

    Property property = new Property.Builder().setPropertyID(propertyID)
            .setPropertyType(new PropertyType())
            .setAddress(new Address())
            .build();


}
