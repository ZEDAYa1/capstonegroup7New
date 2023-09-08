/*
 * PropertyServiceImpl.java
 * This is the PropertyServiceImpl test
 * Author: Tshegofatso Molefe {219001235}
 * Date: 5 September 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class PropertyServiceImplTest {
@Autowired

    private static PropertyServiceImpl propertyService = null;
    private static Property property = PropertyFactory.createProperty("22 Green Street, Maple Tree Place, Cape Town", 3650, "Beautiful, well maintained area close to schools and shops");

    @Test
    void getService() {
    }

    @Test
    void a_create() {
//        Property created = propertyService.create(property);
//        assertNotNull(property.getPropertyID(), created.getPropertyID());
//        System.out.println("Property Created :" + created);
    }

    @Test
    void b_read() {
    }

    @Test
    void c_update() {
    }

    @Test
    void e_delete() {
    }

    @Test
    void d_getAll() {
    }
}