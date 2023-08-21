/*
 * AgentService.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Agent;

import java.util.Set;
@Service
public interface AgentService extends IService <Agent, String>{
    Set<Agent> getAll();
}
