/* AgencyRepositoryTest.java
 Repository test class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Agency;
import za.ac.cput.factory.AgencyFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AgencyRepositoryTest {

    private static AgencyRepository repository = AgencyRepository.getRepository();
    private static Agency agency = AgencyFactory.createAgency("Brooks and Michaels", "0217627492", "brooksandmichaels@mail.com", "333 Main Road, Kenilworth, Cape Town, Western Cape, 7708");

    @Test
    void a_create() {
        Agency created = repository.create(agency);
        assertEquals(agency.getAgencyId(), created.getAgencyId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Agency read = repository.read(agency.getAgencyId());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Agency updated = new Agency.Builder().copy(agency).setContactNumber("0217626492")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(agency.getAgencyId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }

}
