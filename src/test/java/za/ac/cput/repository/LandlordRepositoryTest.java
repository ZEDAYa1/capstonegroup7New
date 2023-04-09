/* LandlordRepositoryTest.java
 Repository test class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 9 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Landlord;
import za.ac.cput.factory.LandlordFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class LandlordRepositoryTest {

    private static LandlordRepository repository = LandlordRepository.getRepository();
    private static Landlord landlord = LandlordFactory.createLandlord("Zachary", "Carstens", "zachary.carstens@icloud.com", "1234567890", "0761148191", "123 ABC Street, Retreat, Cape Town, Western Cape, 7945");

    @Test
    void a_create() {
        Landlord created = repository.create(landlord);
        assertEquals(landlord.getLandlordId(), created.getLandlordId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Landlord read = repository.read(landlord.getLandlordId());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Landlord updated = new Landlord.Builder().copy(landlord).setLandlordFirstName("Kyle")
                .setLandlordLastName("Adams")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(landlord.getLandlordId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }

}