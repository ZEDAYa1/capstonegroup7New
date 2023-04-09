/* LandlordFactory.java
 Factory class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Landlord;
import za.ac.cput.util.Helper;

public class LandlordFactory {

    public static Landlord createLandlord(String landlordFirstName, String landlordLastName, String landlordEmail, String landlordPassword, String landlordPhone, String landlordAddress) {

        String landlordId = Helper.generateId();

        if (!Helper.isValidEmail(landlordEmail))
            return null;

        if (Helper.isNullOrEmpty(landlordFirstName) || Helper.isNullOrEmpty(landlordLastName) || Helper.isNullOrEmpty(landlordPassword) || Helper.isNullOrEmpty(landlordPhone) || Helper.isNullOrEmpty(landlordAddress))
            return null;

        return new Landlord.Builder().setLandlordId(landlordId)
                .setLandlordFirstName(landlordFirstName)
                .setLandlordLastName(landlordFirstName)
                .setLandlordEmail(landlordEmail)
                .setLandlordPassword(landlordPassword)
                .setLandlordPhone(landlordPhone)
                .setLandlordAddress(landlordAddress)
                .build();

    }

}
