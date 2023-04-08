package za.ac.cput.factory;

import za.ac.cput.domain.PropertyType;
import za.ac.cput.util.Helper;

public class PropertyTypeFactory {
    public static Object createPropertyType(String apartment, String house, String townhouse){
        if (Helper.isNullOrEmpty(apartment) || Helper.isNullOrEmpty(house) || Helper.isNullOrEmpty(townhouse)){
            return null;
        }

        PropertyType propertyType = new PropertyType.Builder().setApartment(apartment)
                .setHouse(house)
                .setTownhouse(townhouse)
                .build();
        return propertyType;
    }
}

