/*
 * PropertyFactoryTest.java
 * This is the test for the Property entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 8 April 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Property;
import za.ac.cput.domain.PropertyType;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PropertyFactoryTest {
    @Test
    public void test1() {
        Property property = PropertyFactory.createProperty(new PropertyType(),
                new Address(),
                25150, 2, 1, true);
        System.out.println(property.toString());
        assertNotNull(property);
    }
    @Test
    public void test2() {
        Property property = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        System.out.println(property.toString());
        assertNotNull(property);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Testing Equality
    @Test
    public void testNotEqual(){
        Property p1 = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        Property p2 = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("002", "Main Street", "Cape Town", "Western Cape"),
                50235, 2, 2, true);
        assertNotEquals(p1, p2);
    }

    @Test
    public void testEquality(){
        Property prop1 = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        Property prop2 = prop1;
        assertEquals(prop1, prop2);
    }

    //Testing Object Identity
    @Test
    public void testObjectID(){
        Property property1 = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);

        Property property2 = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        assertNotSame(property1, property2);
    }

    //Failing Test
    @Test
    public void failTest(){
        Property p = PropertyFactory.createProperty(new PropertyType(new PropertyType.Builder()),
                AddressFactory.createAddress("", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        failTest();
    }

    @Timeout(value = 120, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeout(){
        Property property = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        for (int i = 0; i < 3000; i++) {
            System.out.println(i);
        }
    }

    //Disabling Tests
    @Disabled
    @Test
    public void disableTest(){
        Property property = PropertyFactory.createProperty(new PropertyType(),
                AddressFactory.createAddress("10", "VarsityStreet", "Belhar", "Western Cape"),
                25150, 2, 1, true);
        System.out.println(property.toString());

    }


}