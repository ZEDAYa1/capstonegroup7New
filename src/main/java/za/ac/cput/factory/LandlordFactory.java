/* LandlordFactory.java
 Factory class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Landlord;
import za.ac.cput.util.Helper;

public class LandlordFactory {

    public static Landlord createLandlord(String landlordId, String firstname, String lastname, String contactNumber, String email, String password, String address) {
        Helper.checkStringParam("landlordId", landlordId);
        Helper.checkStringParam("firstname", firstname);
        Helper.checkStringParam("lastname", lastname);
        Helper.checkStringParam("contactNumber", contactNumber);
        Helper.checkStringParam("email", email);
        Helper.checkStringParam("password", password);
        Helper.checkStringParam("address", address);

        return new Landlord.Builder()
                .setLandlordId(landlordId)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setPassword(password)
                .setAddress(address)
                .build();
    }
}

