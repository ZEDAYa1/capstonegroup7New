/*ContactRepositoryTest.java
 Author: Sibusiso Dwayi(220226466)
 Date: 8 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ContactRepositoryTest {

    private static ContactRepository repository = ContactRepository.getRespository();

    private static Contact contact = ContactFactory.createContact("Sibusiso","Dwayi","sibusisodwayi05@gmail.com","0842874758");

    @Test
    void a_create() {
        Contact created = repository.create(contact);
        assertEquals(contact.getContactId(),created.getContactId());
        System.out.println("Create: " +created);
    }

    @Test
    void b_read() {
        Contact read = repository.read(contact.getContactId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Contact updated = new Contact.ContactBuilder().copy(contact).setFirstName("Mr Kruben")
                .setLastName("Naidoo")
                .setEmail("Naidoo@gmail.com")
                .setPhone("0762544121")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(contact.getContactId());
        assertTrue(success);
        System.out.println("Deleted "+ success);
    }

    @Test
    void e_getAll() {
        System.out.println(("Show all: "));
        System.out.println((repository.getAll()));
    }
}