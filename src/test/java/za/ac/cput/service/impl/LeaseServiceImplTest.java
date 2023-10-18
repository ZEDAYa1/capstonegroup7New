package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Lease;
import za.ac.cput.factory.LeaseFactory;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
/* LeaseServiceImplTest.java
 *  This is a service test for Lease entity
 *  Zachariah Matsimella 220097429
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LeaseServiceImplTest {

    private static Lease lease1 = LeaseFactory.createLease("No smoking.", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-01"));

    private static Lease lease2 = LeaseFactory.createLease("No pets allowed.", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-12-01"));

    private static Lease lease3 = LeaseFactory.createLease("Only two adults allowed.", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-10-01"));

    @Autowired
    private LeaseServiceImpl service;

    @Test
    void a_save(){
        Lease create1 = service.save(lease1);
        assertEquals(lease1.getLeaseId(), create1.getLeaseId());
        System.out.println("Created: "+ create1);

        Lease create2 = service.save(lease2);
        assertEquals(lease2.getLeaseId(), create2.getLeaseId());
        System.out.println("Created: "+ create2);

        Lease create3 = service.save(lease3);
        assertEquals(lease3.getLeaseId(), create3.getLeaseId());
        System.out.println("Created: "+ create3);
    }

    @Test
    void b_read(){
        Lease readLease = service.read(lease1.getLeaseId());
        assertEquals(readLease.getLeaseId(), lease1.getLeaseId());
        System.out.println("Reading lease: "+ readLease);
    }

    /*@Test
    void c_update(){
        Lease updateLease = service.update(lease1.getLeaseId());
        assertNotEquals(lease1, updateLease);
        System.out.println("Before lease update: "+ lease1);
        System.out.println("After lease update: "+ updateLease);
    }
*/
    @Test
    void d_delete(){
        boolean deleteLease = service.delete(lease1.getLeaseId());
        assertNotNull(!deleteLease);
        System.out.println("Deleted: "+ deleteLease);
    }

    @Test
    void e_findAll(){
        System.out.println("Find all:");
        System.out.println(service.findAll());
    }

}
