/* AgencyFactoryTest.java
 Factory test class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Agency;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AgencyFactoryTest {
    @Test
    void test() {
        Agency agency = AgencyFactory.createAgency("Zachary", "0842874758", "zac@gmail.com", "143 sir lowry road");
        System.out.println(agency.toString());
        assertNotNull(agency);
    }

    @Test
    void test_fail() {
        Agency agency = AgencyFactory.createAgency("Zachary", "0842874758", "zac@gmail.com", "143 sir lowry road");
        System.out.println(agency.toString());
        assertNotNull(agency);
    }

    @Test
    public void test_equality() {
        Agency agency = AgencyFactory.createAgency("Zachary", "0842874758", "zac@gmail.com", "143 sir lowry road");
        Agency agency2 = AgencyFactory.createAgency("Zachary", "0842874758", "zac@gmail.com", "143 sir lowry road");
        assertEquals(agency, agency2);
    }

    @Test
    @Timeout(1) //Seconds
    public void timeOutTest() {
        Agency agency = AgencyFactory.createAgency("Zachary", "0842874758", "zac@gmail.com", "143 sir lowry road");
        try {
            Thread.sleep(600);
            assertEquals(agency.getAgencyId(), agency.getAgencyId());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
