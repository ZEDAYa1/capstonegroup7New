package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Lease;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/* LeaseControllerTest.java
 *  This is a factory test for Lease entity
 *  Zachariah Matsimella 220097429
 */
public class LeaseFactoryTest {
    @Test
    public void test(){
        Lease lease = LeaseFactory.createLease("No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        System.out.println(lease.toString());
        assertNotNull(lease);
    }
    @Test
    public void test_fail(){
        Lease lease = LeaseFactory.createLease("No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        System.out.println(lease.toString());
        assertNotNull(lease);

    }
    @Test
    public void testEquality(){
        Lease lease1 = LeaseFactory.createLease("No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        Lease lease2 = lease1;
        assertEquals(lease1, lease2);

    }


    @Test
    public void testIdentity(){
        Lease lease1 = LeaseFactory.createLease("No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        Lease lease2 = LeaseFactory.createLease("No children allowed.", LocalDate.parse("2021-01-01"), LocalDate.parse("2022-01-01"));
        assertNotSame(lease1, lease2);

    }


    @Test
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    public void testTimeout(){
        System.out.println("Timeout passed");


    }


    @Test
    @Disabled
    public void testdisabled() {

        System.out.println("test disabled");
    }
}
