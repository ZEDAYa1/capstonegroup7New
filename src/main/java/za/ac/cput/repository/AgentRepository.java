/*
 * AgentRepository.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.repository;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Agent;

import java.util.HashSet;
import java.util.Set;
@Repository
public class AgentRepository implements IAgentRepository{
    private static AgentRepository repository =null;
    private Set<Agent> agentDB = null;
    private AgentRepository(){
        agentDB = new HashSet<Agent>();
    }
    public static AgentRepository getRepository(){
        if (repository == null){
            repository = new AgentRepository();
        }
        return repository;
    }

    @Override
    public Agent create(Agent agent) {
        boolean success = agentDB.add(agent);
        if (!success)
        return null;
        return agent;
    }

    @Override
    public Agent read(String agentId) {
        for (Agent a : agentDB){
            if (a.getAgentId().equals(agentId))
                return a;
        }
        return null;
    }

    @Override
    public Agent update(Agent agent) {
        Agent oldAgent = read(agent.getAgentId());
        if (oldAgent != null){
            agentDB.remove(oldAgent);
            agentDB.add(agent);
            return agent;
        }
        return null;
    }

    @Override
    public boolean delete(String agentId) {
        Agent agentToDelete = read(agentId);
        if (agentToDelete == null)
        return false;
        agentDB.remove(agentToDelete);
        return true;
    }

    @Override
    public Set<Agent> getAll() {
        return agentDB;
    }
}
