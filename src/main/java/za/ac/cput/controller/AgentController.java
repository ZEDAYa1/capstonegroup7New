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

    @PostMapping("save")
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.save(agent);
    }

    @GetMapping("read/{id}")
    public Agent getAgent(@PathVariable String id) {
        return agentService.read(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteAgent(@PathVariable String id) {
        return agentService.delete(id);
    }

    @GetMapping("all")
    public Set<Agent> findAllLandlords() {
        return agentService.findAll();
    }
}
