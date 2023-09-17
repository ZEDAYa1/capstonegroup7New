package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Lease;
import za.ac.cput.service.LeaseService;

import java.util.List;

@RestController
@RequestMapping("/lease")
public class LeaseController {

    private LeaseService leaseService;

    @Autowired
    LeaseController(LeaseService service){
        this.leaseService = service;
    }

    @PostMapping("/create")
    public Lease create(@RequestBody Lease lease){
        return leaseService.create(lease);
    }

    @GetMapping("/read/{id}")
    public Lease read(@PathVariable String id){
        return leaseService.read(id);
    }

    @PostMapping("/update")
    public Lease update(@RequestBody Lease lease){
        return leaseService.update(lease);
    }

    @DeleteMapping("/delete{id}")
    public boolean delete(@PathVariable String id){
        return leaseService.delete(id);
    }

    @GetMapping("/getall")
    public List<Lease> getAll(){
        return leaseService.getAll();
    }
}
