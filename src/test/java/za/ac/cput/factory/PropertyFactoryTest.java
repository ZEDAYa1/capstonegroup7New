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
import za.ac.cput.domain.Property;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class PropertyFactoryTest {
    @Test
    public void test1() {
        Property property = PropertyFactory.createProperty("14", "South Point Belhar",5600,"Property is close to schools, shopping centers and other amenities");
        System.out.println(property.toString());
        assertNotNull(property);
    }
    @Test
    public void test2() {
        Property property = PropertyFactory.createProperty("10 Varsity Street Belhar","10 Varsity Street Belhar",20502,"Property close to transport");
        System.out.println(property.toString());
        assertNotNull(property);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////

    //Testing Equality
    @Test
    public void testNotEqual(){
        Property p1 = PropertyFactory.createProperty("10 Varsity Stree Belhar","Varsity Stree Belhar",25000,"Property is close to schools, shopping centers and other amenities");
        Property p2 = PropertyFactory.createProperty("02 Main Stree Cape Town"," Main Stree Cape Town",24000,"Property is close to schools, shopping centers and other amenities");
        assertNotEquals(p1, p2);
    }

    @Test
    public void testEquality(){
        Property prop1 = PropertyFactory.createProperty("10 Varsity Street Belhar","Varsity Street Belhar",24000,"Varsity Street Belhar");
        Property prop2 = prop1;
        assertEquals(prop1, prop2);
    }


    //Failing Test
    @Test
    public void failTest(){
        Property p = PropertyFactory.createProperty("","",50000,"Property is close to schools, shopping centers and other amenities");
        failTest();
    }

    @Timeout(value = 120, unit = TimeUnit.MILLISECONDS)
    @Test
    public void testTimeout(){
        Property property = PropertyFactory.createProperty("10" ,"Varsity Street Belhar",25150,"Property is close to schools, shopping centers and other amenities");
        for (int i = 0; i < 3000; i++) {
            System.out.println(i);
        }
    }

    //Disabling Tests
    @Disabled
    @Test
    public void disableTest(){
        Property property = PropertyFactory.createProperty("10 ","Varsity Street Belhar",15000,"Property is close to schools, shopping centers and other amenities");
        System.out.println(property.toString());

    }


}