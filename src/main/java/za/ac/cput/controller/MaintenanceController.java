package za.ac.cput.controller;
//sonwabiso Moni
//219275041
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.factory.MaintenanceFactory;
import za.ac.cput.service.MaintenanceService;

import java.util.Set;

@RestController
@RequestMapping("/maintenancies")
@Slf4j
public class MaintenanceController {
    private final MaintenanceService maintenanceService;

    @Autowired
    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @PostMapping("save")
    public ResponseEntity<Maintenance> save(@RequestBody Maintenance maintenance) {
        log.info("Save request: {}", maintenance);
        Maintenance validatedMaintenance;
        try {
            validatedMaintenance = MaintenanceFactory.createMaintenance(maintenance.getDescription(), maintenance.getRequestDate());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Maintenance save = maintenanceService.save(validatedMaintenance);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request{}", id);
        this.maintenanceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Maintenance> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Maintenance maintenance = this.maintenanceService.read(id);
        return ResponseEntity.ok(maintenance);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Maintenance>> findAll() {
        Set<Maintenance> maintenances = this.maintenanceService.findAll();
        return ResponseEntity.ok(maintenances);
    }
}






