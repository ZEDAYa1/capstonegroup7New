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
import za.ac.cput.domain.Agent;
import za.ac.cput.factory.AgentFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class AgentServiceImplTest {
    private static final Agent agent1 = AgentFactory.createAgent("sibusiso","dwayi", "0842874758","sibu@gmail.com","Sbudwayi","143 sir lowry road");
    private static final Agent agent2 = AgentFactory.createAgent("soso","moni", "087287475", "sos@gmail.com","SosoMoni","144 Main road");
    private static final Agent agent3 = AgentFactory.createAgent("luyolo","nzima", "0610796008","luyolo@gmail.com","Luyolonzima","10 Dorset street");

    @Autowired
    private AgentServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Agent created1 = service.save(agent1);
        assertNotNull(created1);
        System.out.println(created1);

        Agent created2 = service.save(agent2);
        assertNotNull(created2);
        System.out.println(created2);

        Agent created3 = service.save(agent3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Agent read = service.read(agent1.getAgentId());
        assertEquals(read.getAgentId(), agent1.getAgentId());
        System.out.println("Show agent: " + read);
    }

    @Test
    void c_update() {
        Agent updatedAgent = new Agent.Builder().copy(agent2).setContactnumber("0856399745").build();
        Agent updated = service.update(updatedAgent);
        assertNotNull(agent2);
        System.out.println("Updated: " + updated);
    }
    @Test
    void f_delete() {
        boolean success = service.delete(agent3.getAgentId());
        assertTrue(success);
        System.out.println("Delete agent: " + success);
    }

    @Test
    void d_getALl() {
        System.out.println("Show all agents: ");
        System.out.println(service.findAll());
    }
}