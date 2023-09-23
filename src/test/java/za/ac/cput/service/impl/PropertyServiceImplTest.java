/*
 * AgentServiceImplTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class PropertyServiceImplTest {
    private static Property property1 = PropertyFactory.createProperty("10 Varsity Street, Belhar, 7493", "10 Varsity Street, Belhar, 7493",
            5600,"Spacious, Well maintained, close to shops and schools");
    private static Property property2 = PropertyFactory.createProperty("10 Varsity Street, Belhar, 7493", "10 Varsity Street, Belhar, 7493",
            5600,"Spacious, Well maintained, close to shops and schools");
    private static Property property3 = PropertyFactory.createProperty("10 Varsity Street, Belhar, 7493", "10 Varsity Street, Belhar, 7493",
            5600,"Spacious, Well maintained, close to shops and schools");

    @Autowired
    private PropertyServiceImpl service;

    @Test
    void a_save() {
        Property created = service.save(property1);
        assertEquals(property1.getPropertyId(), created.getPropertyId());
        System.out.println("Created: "+ created);

        Property created2 = service.save(property2);
        assertEquals(property2.getPropertyId(), created2.getPropertyId());
        System.out.println("Created: "+ created2);

        Property created3 = service.save(property3);
        assertEquals(property3.getPropertyId(), created3.getPropertyId());
        System.out.println("Created: "+ created3);
    }

    @Test
    void b_read() {
        Property read = service.read(property1.getPropertyId());
        assertEquals(read.getPropertyId(), property1.getPropertyId());
        System.out.println("Show property: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(property3.getPropertyId());
        assertTrue(success);
        System.out.println("Delete property: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all properties: ");
        System.out.println(service.findAll());
    }
}
