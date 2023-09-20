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
import za.ac.cput.domain.Agency;
import za.ac.cput.factory.AgencyFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class AgencyServiceImplTest {
    private static final Agency agency1 = AgencyFactory.createAgency("12345678", "sibusiso", "0842874758", "sibu@gmail.com", "143 sir lowry road");
    private static final Agency agency2 = AgencyFactory.createAgency("87654321","soso", "087287475","sos@gmail.com","144 SIr Lowry road");
    private static final Agency agency3 = AgencyFactory.createAgency("00334466","luyolo","0610796008","luyolo@gmail.com","Victor road");

    @Autowired
    private AgencyServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Agency created1 = service.save(agency1);
        assertNotNull(created1);
        System.out.println(created1);

        Agency created2 = service.save(agency2);
        assertNotNull(created2);
        System.out.println(created2);

        Agency created3 = service.save(agency3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Agency read = service.read(agency1.getAgencyId());
        assertEquals(read.getAgencyId(), agency1.getAgencyId());
        System.out.println("Show agent: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(agency3.getAgencyId());
        assertTrue(success);
        System.out.println("Delete agent: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Show all agents: ");
        System.out.println(service.findAll());
    }
}
