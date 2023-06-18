/*
 * AgentFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Agent;
import static org.junit.jupiter.api.Assertions.*;

class AgentFactoryTest {
    @Test
    void test() {
        Agent agent = AgentFactory.createAgent("Sibusiso", "Dwayi", "0842874758", "dwayisibusiso@gmail.com", "Dwayi05", "143 Sir Lowry Woodstock");
        System.out.println(agent.toString());
        assertNotNull(agent);
    }

    @Test
    void test_fail() {
        Agent agent = AgentFactory.createAgent("", "Dwayi", "0842874758", "dwayisibusiso@gmail.com", "Dwayi05", "143 Sir Lowry Woodstock");
        System.out.println(agent.toString());
        assertNotNull(agent);
    }
}
