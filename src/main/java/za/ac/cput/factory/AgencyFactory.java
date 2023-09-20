/* AgencyFactory.java
 Factory class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Agency;
import za.ac.cput.util.Helper;

public class AgencyFactory {

    public static Agency createAgency(String agencyId, String name, String contactNumber, String email, String address) {
        Helper.checkStringParam("agencyId", agencyId);
        Helper.checkStringParam("name", name);
        Helper.checkStringParam("contactNumber", contactNumber);
        Helper.checkStringParam("email", email);
        Helper.checkStringParam("address", address);

        return new Agency.Builder()
                .setAgencyId(agencyId)
                .setName(name)
                .setContactNumber(contactNumber)
                .setEmail(email)
                .setAddress(address)
                .build();
    }
}
