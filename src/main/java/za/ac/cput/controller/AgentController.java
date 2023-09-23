/*
 * Agent.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Agent;
import za.ac.cput.factory.AgentFactory;
import za.ac.cput.service.AgentService;

import java.util.Set;

@RestController
@RequestMapping("capstonegroup7/agent/")
@Slf4j
public class AgentController {
    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("save")
    public ResponseEntity<Agent> save(@RequestBody Agent agent) {
        log.info("Save request: {}", agent);
        Agent validatedAgent;
        try {
            validatedAgent = AgentFactory.createAgent(agent.getAgentId(), agent.getFirstname(), agent.getLastname(),agent.getContactnumber(), agent.getEmail(), agent.getPassword(), agent.getAddress());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Agent save = agentService.save(validatedAgent);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.agentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Agent> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Agent agent = this.agentService.read(id);
        return ResponseEntity.ok(agent);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Agent>> findAll() {
        Set<Agent> agents = this.agentService.findAll();
        return ResponseEntity.ok(agents);
    }

}
