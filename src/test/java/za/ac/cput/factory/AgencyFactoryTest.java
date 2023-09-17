/* AgencyFactoryTest.java
 Factory test class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Agency;
import static org.junit.jupiter.api.Assertions.*;

class AgencyFactoryTest {

    @Test
    public void test() {
        Agency agency = AgencyFactory.createAgency("Brooks and Michaels", "0217627492", "brooksandmichaels@mail.com", "333 Main Road, Kenilworth, Cape Town, Western Cape, 7708");
        System.out.println(agency.toString());
        assertNotNull(agency);
    }

}
