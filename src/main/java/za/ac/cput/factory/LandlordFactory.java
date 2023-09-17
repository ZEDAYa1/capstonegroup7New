/* LandlordFactory.java
 Factory class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Landlord;
import za.ac.cput.util.Helper;

public class LandlordFactory {

    public static Landlord createLandlord(String firstName, String lastName, String contactNumber, String email, String password, String address) {

        String landlordId = Helper.generateId();

        if (!Helper.isValidEmail(email))
            return null;

        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(contactNumber) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(address))
            return null;

        return new Landlord.Builder().setLandlordId(landlordId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                .build();

    }

}
