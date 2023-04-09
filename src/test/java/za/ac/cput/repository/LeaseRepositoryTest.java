package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Lease;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/* LeaseRepositoryTest.java
 *  This is a test for Lease repository entity
 *  Zachariah Matsimella 220097429
 */
public class LeaseRepositoryTest {
    public static LeaseRepository repository = LeaseRepository.getRepository();
    public static Lease lease = new Lease.Builder()
            .setLessor("Dian Smit")
            .setLessee("Mandisa Nyadenga")
            .setStartDate(new Date(2023, 06, 01))
            .setEndDate(new Date(2024, 06, 01))
            .build();
    @Test
    void a_create() {
        Lease newLease = repository.create(lease);
        assertNotNull(newLease);
        System.out.println(newLease);
    }

    @Test
    void b_read(){
        Lease readLease = repository.read(lease.getLeaseId());
        assertNotNull(readLease);
        System.out.println(readLease);
    }

    @Test
    void c_update(){
        Lease updateLease = new Lease.Builder()
                .copy(lease)
                .setLessor("Michael Johnson")
                .setLessee("Kelly Nolte")
                .setStartDate(new Date(2025, 10, 22))
                .setEndDate(new Date(2026, 10, 22))
                .build();
        assertNotNull(updateLease);
        System.out.println(updateLease);
    }

    @Test
    void e_delete(){
        boolean successful = repository.delete(lease.getLeaseId());
        assertTrue(successful);
        System.out.println(successful);
    }
}
