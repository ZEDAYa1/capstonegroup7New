/* LandlordFactoryTest.java
 Factory test class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Landlord;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LandlordFactoryTest {
    @Test
    void test() {
        Landlord landlord = LandlordFactory.createLandlord("12345678", "John", "Doe", "0842874758", "johndoe@gmail.com", "password","123 Main Street");
        System.out.println(landlord.toString());
        assertNotNull(landlord);
    }

    @Test
    void test_fail() {
        Landlord landlord = LandlordFactory.createLandlord("", "John", "Doe", "0842874758", "johndoe@gmail.com", "password","123 Main Street");
        System.out.println(landlord.toString());
        assertNotNull(landlord);
    }

    @Test
    public void test_equality() {
        Landlord landlord1 = LandlordFactory.createLandlord("12345678", "John", "Doe", "0842874758", "johndoe@gmail.com", "password","123 Main Street");
        Landlord landlord2 = LandlordFactory.createLandlord("12345678", "John", "Doe", "0842874758", "johndoe@gmail.com", "password","123 Main Street");
        assertEquals(landlord1, landlord2);
    }

    @Test
    @Timeout(1) // Seconds
    public void timeOutTest() {
        Landlord landlord = LandlordFactory.createLandlord("12345678", "John", "Doe", "0842874758", "johndoe@gmail.com", "password","123 Main Street");
        try {
            Thread.sleep(600);
            assertEquals(landlord.getLandlordId(), landlord.getLandlordId());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
