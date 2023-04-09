/* ContactFactoryTest.java
 Author: Sibusiso Dwayi(220226466)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;

import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest {

    @Test
    void test() {
        Contact contact = ContactFactory.createContact("Sibusiso","Dwayi","sibusisodwayi05@gmail.com","0842874758");
        System.out.println(contact.toString());
        assertNotNull(contact);
    }
    @Test
    void test_fail(){
        Contact contact = ContactFactory.createContact("","Dwayi","sibusisodwayi05@gmail.com","0842874758");
        System.out.println(contact.toString());
        assertNotNull(contact);

    }

}