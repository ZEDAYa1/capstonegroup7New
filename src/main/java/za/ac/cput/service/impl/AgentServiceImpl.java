/*
 * AgentServiceImpl.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Agent;
import za.ac.cput.repository.IAgentRepository;
import za.ac.cput.service.AgentService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private final IAgentRepository repository;

    @Autowired
    public AgentServiceImpl(IAgentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Agent save(Agent agent) {
        return this.repository.save(agent);
    }

    @Override
    public Agent read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Agent update(Agent agent) {
        if (this.repository.existsById(agent.getAgentId())) {
            return this.repository.save(agent);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }


    @Override
    public Set<Agent> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

//    @Override
//    public Set<Agent> getAll() {
//        return null;
//    }
}

