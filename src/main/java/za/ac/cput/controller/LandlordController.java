package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Landlord;
import za.ac.cput.service.LandlordService;

import java.util.Set;

@RestController
@RequestMapping("/landlords")
public class LandlordController {
    private final LandlordService landlordService;

    @Autowired
    public LandlordController(LandlordService landlordService) {
        this.landlordService = landlordService;
    }

    @PostMapping("save")
    public Landlord createLandlord(@RequestBody Landlord landlord) {
        return landlordService.save(landlord);
    }

    @GetMapping("read/{id}")
    public Landlord getLandlord(@PathVariable String id) {
        return landlordService.read(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteLandlord(@PathVariable String id) {
        return landlordService.delete(id);
    }

    @GetMapping("all")
    public Set<Landlord> findAllLandlords() {
        return landlordService.findAll();
    }
}

