/* LandlordFactoryTest.java
 Factory test class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Landlord;
import static org.junit.jupiter.api.Assertions.*;

class LandlordFactoryTest {

    @Test
    public void test() {
        Landlord landlord = LandlordFactory.createLandlord("Zachary", "Carstens", "0761148191", "zachary.carstens@icloud.com", "1234567890", "123 ABC Street, Retreat, Cape Town, Western Cape, 7945");
        System.out.println(landlord.toString());
        assertNotNull(landlord);
    }

}