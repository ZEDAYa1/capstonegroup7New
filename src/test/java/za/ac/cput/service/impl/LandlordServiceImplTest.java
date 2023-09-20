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
import za.ac.cput.domain.Landlord;
import za.ac.cput.factory.LandlordFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LandlordServiceImplTest {
    private static final Landlord landlord1 = LandlordFactory.createLandlord("12345678", "John", "Doe", "0842874758", "john@example.com","password","123 Main St");
    private static final Landlord landlord2 = LandlordFactory.createLandlord("87654321", "Jane", "Smith", "0762584575", "jane@example.com","password","456 Elm St");
    private static final Landlord landlord3 = LandlordFactory.createLandlord("00334466", "Alice", "Johnson", "0610259815", "alice@example.com","password","789 Oak St");

    @Autowired
    private LandlordServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Landlord created1 = service.save(landlord1);
        assertNotNull(created1);
        System.out.println(created1);

        Landlord created2 = service.save(landlord2);
        assertNotNull(created2);
        System.out.println(created2);

        Landlord created3 = service.save(landlord3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Landlord read = service.read(landlord1.getLandlordId());
        assertEquals(read.getLandlordId(), landlord1.getLandlordId());
        System.out.println("Show landlord: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(landlord3.getLandlordId());
        assertTrue(success);
        System.out.println("Delete landlord: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all landlords: ");
        System.out.println(service.findAll());
    }
}
