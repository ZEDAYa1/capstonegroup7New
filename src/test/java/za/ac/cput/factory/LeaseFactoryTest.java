package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Lease;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
/* LeaseFactoryTest.java
 *  This is a test for Lease entity
 *  Zachariah Matsimella 220097429
 */
public class LeaseFactoryTest {

    @Test
    public void test1() {
        Lease lease = new Lease.Builder()
                .setLessor("Dian Smit")
                .setLessee("Mandisa Nyadenga")
                .setStartDate(new Date(2023, 06, 01))
                .setEndDate(new Date(2024, 06, 01))
                .build();
        System.out.println(lease);

        Lease lease1 = new Lease.Builder()
                .setLessor("Dian Smit")
                .setLessee("Mandisa Nyadenga")
                .setStartDate(new Date(2023, 06, 01))
                .setEndDate(new Date(2024, 06, 01))
                .build();
        System.out.println(lease1);

        assertEquals(lease, lease1);
    }

    @Test
    public void test2() {
        Lease lease = LeaseFactory.createLease("Xavier Leander", "Mandisa Nyadenga", new Date(2024, 05, 18), new Date(2025, 05, 18));
        System.out.println(lease.toString());
        assertNotNull(lease);
    }
}