/*
 * IAgentRepository.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.repository;

import za.ac.cput.domain.Agent;

import java.util.Set;

public interface IAgentRepository extends iRepository<Agent, String> {
    public Set<Agent> getAll();
}
