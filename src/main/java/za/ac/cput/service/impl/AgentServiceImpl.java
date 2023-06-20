package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Agent;
import za.ac.cput.repository.AgentRepository;
import za.ac.cput.service.AgentService;

import java.util.Set;
@Service
public class AgentServiceImpl implements AgentService {
    private static AgentServiceImpl service = null;
    private static AgentRepository repository =null;
    private AgentServiceImpl(){
        repository = AgentRepository.getRepository();
    }
    public static AgentServiceImpl getService(){
        if (service == null){
            service = new AgentServiceImpl();
        }
        return service;
    }

    @Override
    public Agent create(Agent agent) {
        Agent created = repository.create(agent);
        return created;
    }

    @Override
    public Agent read(String agentId) {
        Agent readAgent = repository.read(agentId);
        return readAgent;
    }

    @Override
    public Agent update(Agent agent) {
        Agent updated = repository.update(agent);
        return updated;
    }

    @Override
    public boolean delete(String agentId) {
        boolean success = repository.delete(agentId);
        return success;
    }
    @Override
    public Set<Agent> getAll() {
        return repository.getAll();
    }
}
