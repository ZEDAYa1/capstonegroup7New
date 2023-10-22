package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class PropertyServiceImplTest {
    private static Property property1 = PropertyFactory.createProperty("10 Varsity Street, Belhar, 7493",
            5600,"Spacious, Well maintained, close to shops and schools");
    private static Property property2 = PropertyFactory.createProperty("143 Main Street, Woodstock, 7500",
            4500,"Small yard, Well maintained, very close to the beach");
    private static Property property3 = PropertyFactory.createProperty("140 Dorset Street, Town, 8000",
            7500,"Very Big, Town House, close to schools");

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
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Property newProperty = new Property.Builder().copy(property3).setRentAmount(5800).build();
        Property updated = service.update(newProperty);
        assertNotNull(property3);
        System.out.println("updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean deleted = service.delete(property2.getPropertyId());
        assertNotNull(deleted);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All");
        System.out.println(service.findAll());
    }
}
