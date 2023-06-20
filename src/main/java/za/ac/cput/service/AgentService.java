package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Agent;

import java.util.Set;
@Service
public interface AgentService extends IService <Agent, String>{
    Set<Agent> getAll();
}
