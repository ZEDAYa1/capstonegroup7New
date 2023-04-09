/* ComplaintRepositoryTest.java
 Author: Sibusiso Dwayi(220226466)
 Date: 8 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Complaint;
import za.ac.cput.domain.Contact;
import za.ac.cput.factory.ComplaintFactory;
import za.ac.cput.factory.ContactFactory;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ComplaintRepositoryTest {
    private static ComplaintRepository repository = ComplaintRepository.getRespository();

    private static Complaint complaint = ComplaintFactory.createComplaint("There were Cockroaches in the cupboards","03/04/2023","Pending");

    @Test
    void a_create() {
        Complaint created = repository.create(complaint);
        assertEquals(complaint.getComplaintId(),created.getComplaintId());
        System.out.println("Create: " +created);
    }

    @Test
    void b_read() {
        Complaint read = repository.read(complaint.getComplaintId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Complaint updated = new Complaint.ComplaintBuilder().copy(complaint).setDescription("There were Cockroaches in the cupboards")
                .setStatus("Fumigation Completed")
                .setDate("07/04/2023")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(complaint.getComplaintId());
        assertTrue(success);
        System.out.println("Deleted "+ success);
    }

    @Test
    void e_getAll() {
        System.out.println(("Show all: "));
        System.out.println((repository.getAll()));
    }
}