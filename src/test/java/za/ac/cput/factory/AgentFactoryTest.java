/*
 * AgentFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
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
    @Test
    public void test_equality() {
         Agent agent = AgentFactory.createAgent("Sibusiso", "Dwayi", "0842874758","dwayisibusiso@gmail.com","Dwayi05","143 Sir Lowry Woodstock");
         Agent agent2 = AgentFactory.createAgent("Sibusiso","Dwayi","0842874758","dwayisibusiso@gmail.com","Dwayi05","143 Sir Lowry Woodstock");
         assertEquals(agent,agent2);
    }
    @Test
    @Timeout(1) //Seconds
    public void timeOutTest() {
        Agent agent = AgentFactory.createAgent("Sibusiso","Dwayi","0842874758","dwayisibusiso@gmail.com","Dwayi05","143 Sir Lowry Woodstock");
        try {
            Thread.sleep(600);
            assertEquals(agent.getAgentId(),agent.getAgentId());
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
