package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Lease;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/* LeaseFactoryTest.java
 *  This is a test for Lease entity
 *  Zachariah Matsimella 220097429
 */
public class LeaseFactoryTest {

    @Test
    public void test1() {
        Lease lease = LeaseFactory.createLease("","No smoking", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-01"));
        System.out.println(lease.toString());
        assertNotNull(lease);
    }

    @Test
    public void test2() {
        Lease lease = LeaseFactory.createLease("","No pets allowed", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-01"));
        System.out.println(lease.toString());
        assertNotNull(lease);
    }

    //Testing Equality
    @Test
    public void testNotEqual(){
        Lease l1 = LeaseFactory.createLease("","No smoking", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-01"));
        Lease l2 = LeaseFactory.createLease("","No pets allowed", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-12-01"));
        assertNotEquals(l1, l2);
    }

    @Test
    public void testEquality(){
        Lease lease1 = LeaseFactory.createLease("","No pets allowed", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-12-01"));
        Lease lease2 = lease1;
        assertEquals(lease1, lease2);
    }


    //Failing Test
    @Test
    public void failTest(){
        Lease l = LeaseFactory.createLease("123","No terms.", LocalDate.parse("2022-01-01"), LocalDate.parse("2022-12-01"));
        failTest();
    }

    //Timeout Test
    @Timeout(value = 120, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeout(){
        Lease lease = LeaseFactory.createLease("","No smoking", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-01"));
        for (int i = 0; i < 3000; i++) {
            System.out.println(i);
        }
    }

    //Disabling Tests
    @Disabled
    @Test
    public void disableTest(){
        Lease lease = LeaseFactory.createLease("","No smoking", LocalDate.parse("2022-01-01"), LocalDate.parse("2023-01-01"));
        System.out.println(lease.toString());

    }
}