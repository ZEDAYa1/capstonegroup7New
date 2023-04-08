/*
 * AddressFactory.java
 * This is the AddressFactory class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 8 April 2023
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.util.Helper;

/* String streetNum;
    String streetName;
    String city;
    String province;*/
public class AddressFactory {
    public static Address createAddress(String streetNum, String streetName, String city, String province){
        if (Helper.isNullOrEmpty(streetNum)
                ||Helper.isNullOrEmpty(streetName)
                ||Helper.isNullOrEmpty(city)
                ||Helper.isNullOrEmpty(province)){
            return null;
        }
        Address address = new Address.Builder().setStreetNum(streetNum)
                .setStreetName(streetName)
                .setCity(city)
                .setProvince(province)
                .build();
        return address;
    }
}
