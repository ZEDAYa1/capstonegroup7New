/*
 * PropertyServiceImpl.java
 * This is the PropertyServiceImpl test
 * Author: Tshegofatso Molefe {219001235}
 * Date: 5 September 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class PropertyServiceImplTest {
    @Autowired
    private PropertyServiceImpl service;

    private static Property property = PropertyFactory.createProperty("8 4th Avenue, Belgravia, 7764",
            4800, "Beautiful property, Spacious, Close to most amenities");

    @Test
    void a_create() {
        Property created = service.create(property);
        assertEquals(property.getPropertyID(), created.getPropertyID());
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read() {
        Property read = service.read(property.getPropertyID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Property newProperty = new Property.Builder().copy(property).setRentAmount(5800).build();
        Property updated = service.update(newProperty);
        assertEquals(newProperty.getRentAmount(), updated.getRentAmount());
        System.out.println("updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean deleted = service.delete(property.getPropertyID());
        assertNotNull(deleted);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }
}
