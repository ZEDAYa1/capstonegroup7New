/*
 * AgentRepositoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Agent;
import za.ac.cput.factory.AgentFactory;

import javax.swing.plaf.synth.SynthTabbedPaneUI;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class AgentRepositoryTest {
    private static AgentRepository repository = AgentRepository.getRepository();
    private static Agent agent = AgentFactory.createAgent("Sibusiso", "Dwayi", "0842874758", "dwayisibusiso@gmail.com", "Dwayi05", "143 Sir Lowry Woodstock");

    @Test
    void a_create() {
        Agent created = repository.create(agent);
        assertEquals(agent.getAgentId(),created.getAgentId());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        Agent read = repository.read(agent.getAgentId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_updated() {
        Agent updated = new Agent.AgentBuilder().copy(agent).setFirstName("Luyolo")
                .setLastName("Nzima")
                .setContactNumber("0762555203")
                .setEmail("LNzima@gmail.com")
                .setPassword("LN@123")
                .setAddress("145 Dorset road Woodstock")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(agent.getAgentId());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}

