package za.ac.cput.controller;
//sonwabiso Moni
//219275041
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Landlord;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.factory.MaintenanceFactory;
import za.ac.cput.service.LandlordService;
import za.ac.cput.service.MaintenanceService;

import java.util.Set;

@RestController
@RequestMapping("/maintenancies")
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("save")
    public Maintenance createMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.save(maintenance);
    }

    @GetMapping("read/{id}")
    public Maintenance getMaintenance(@PathVariable String id) {
        return maintenanceService.read(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteMaintenance(@PathVariable String id) {
        return maintenanceService.delete(id);
    }

    @GetMapping("all")
    public Set<Maintenance> findAllMaintenance() {
        return maintenanceService.findAll();
    }
}





