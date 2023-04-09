/*ContactFactory.java
 Author: Sibusiso Dwayi(220226466)
 Date: 3 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

public class ContactFactory {
    public static Contact createContact(String firstName, String lastName, String email, String phone){
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phone)){
            return null;
        }
        String contactId = Helper.generateId();

        if(!Helper.isValidEmail(email)){
            return null;
        }

        return new Contact.ContactBuilder().setContactId(contactId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPhone(phone)
                .build();
    }
}
