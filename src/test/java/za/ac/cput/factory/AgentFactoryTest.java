/*
 * AgentFactoryTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Agent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AgentFactoryTest {
    @Test
    void test() {
        Agent agent = AgentFactory.createAgent("sibusiso","dwayi", "0842874758","sibu@gmail.com","Sbudwayi","143 sir lowry road");
        System.out.println(agent.toString());
        assertNotNull(agent);
    }

    @Test
    void test_fail() {
        Agent agent = AgentFactory.createAgent("","dwayi", "0842874758","sibu@gmail.com","Sbudwayi","143 sir lowry road");
        System.out.println(agent.toString());
        assertNotNull(agent);
    }
    @Test
    public void test_equality() {
        Agent agent = AgentFactory.createAgent("sibusiso","dwayi", "0842874758","sibu@gmail.com","Sbudwayi","143 sir lowry road");
        Agent agent2 = AgentFactory.createAgent("sibusiso","dwayi", "0842874758","sibu@gmail.com","Sbudwayi","143 sir lowry road");
         assertEquals(agent,agent2);
    }
    @Test
    @Timeout(1) //Seconds
    public void timeOutTest() {
        Agent agent = AgentFactory.createAgent("sibusiso","dwayi", "0842874758","sibu@gmail.com","Sbudwayi","143 sir lowry road");
        try {
            Thread.sleep(600);
            assertEquals(agent.getAgentId(),agent.getAgentId());
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
