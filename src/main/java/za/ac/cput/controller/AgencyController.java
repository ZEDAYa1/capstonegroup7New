package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Agency;
import za.ac.cput.domain.Property;
import za.ac.cput.service.AgencyService;

import java.util.Set;

@RestController
@RequestMapping("/agencies")
public class AgencyController {
    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping("save")
    public Agency createAgency(@RequestBody Agency agency) {
        return agencyService.save(agency);
    }

    @GetMapping("read/{id}")
    public Agency getAgency(@PathVariable String id) {
        return agencyService.read(id);
    }
    @PostMapping("/update")
    public Agency update(@RequestBody Agency agency){
        return agencyService.update(agency);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteAgency(@PathVariable String id) {
        return agencyService.delete(id);
    }

    @GetMapping("all")
    public Set<Agency> findAllAgencies() {
        return agencyService.findAll();
    }
}

