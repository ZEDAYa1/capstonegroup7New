/* AgencyFactory.java
 Factory class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Agency;
import za.ac.cput.util.Helper;

public class AgencyFactory {

    public static Agency createAgency(String name, String contactNumber, String email, String address) {

        String agencyId = Helper.generateId();

        if (!Helper.isValidEmail(email))
            return null;

        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(contactNumber) || Helper.isNullOrEmpty(address))
            return null;

        return new Agency.Builder().setAgencyId(agencyId)
                .setName(name)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setAddress(address)
                .build();

    }

}