/*
 * Agent.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Agent;
import za.ac.cput.service.AgentService;

import java.util.Set;

@RestController
@RequestMapping("/agents")
public class AgentController {
    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public Set<Agent> findAllAgents() {
        return agentService.findAll();
    }

    @GetMapping("/{agentId}")
    public Agent getAgent(@PathVariable String id) {
        return agentService.read(id);
    }

    @PostMapping
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.save(agent);
    }

//    @PutMapping("/{id}")
//    public Agent updateAgent(@PathVariable String id, @RequestBody Agent agent) {
//        // Implement the update logic
//        return agentService.update(id);
//    }

    @DeleteMapping("/{agentId}")
    public boolean deleteAgent(@PathVariable String id) {
        return agentService.delete(id);
    }
}

