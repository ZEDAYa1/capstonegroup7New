/*
 * PropertyTest.java
 * This is the test for the Property entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.domain;

import org.junit.jupiter.api.Test;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.PropertyFactory;
import za.ac.cput.factory.PropertyTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {
    @Test
    public void test() {
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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}