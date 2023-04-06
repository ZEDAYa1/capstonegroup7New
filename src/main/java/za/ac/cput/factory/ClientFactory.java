package za.ac.cput.factory;

import za.ac.cput.domain.Client;
import za.ac.cput.util.Helper;

public class ClientFactory {
    public static Client createClient(String firstName, String lastName, String email, String mobileNumber) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)
                || Helper.isNullOrEmpty(mobileNumber)) {
            return null;
        }
        String clientID = Helper.generateId();

        if (!Helper.isValidEmail(email)) {
            return null;
        }

        Client client = new Client.Builder().clientID(clientID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setMobileNumber(mobileNumber)
                .build();

        return client;

    }

}
