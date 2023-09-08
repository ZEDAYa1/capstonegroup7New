/*
 * AgentServiceImplTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Agent;
import za.ac.cput.factory.AgentFactory;
import za.ac.cput.service.impl.AgentServiceImpl;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class AgentServiceImplTest {
    @Autowired
    private static  AgentServiceImpl agentService = null;
    private  Agent agent = AgentFactory.createAgent("Sibusiso","Dwayi","0847525412","Sibu@gmail.com","Sbu03","134 Sir Lowry Road");

    @Test
    void a_create() {
        Agent created = agentService.create(agent);
        assertEquals(agent.getAgentId(),created.getAgentId());
        System.out.println("Created: "+ created);
    }

    @Test
    void b_read() {
        Agent read = agentService.read(agent.getAgentId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Agent newAgent = new Agent.AgentBuilder().copy(agent).setFirstName("Sibu").build();
        Agent updated = agentService.update(newAgent);
        assertEquals(newAgent.getFirstName(),updated.getFirstName());
        System.out.println("Updated: "+ updated);
    }
    @Test
    void e_delete() {
        boolean deleted = AgentServiceImpl.getService().delete(agent.getAgentId());
        assertNotNull((deleted));
        System.out.println("Deleted "+ true );
    }
    @Test
    void d_getAll() {
        System.out.println("Get all: ");
        System.out.println(agentService.getAll());
    }
}
