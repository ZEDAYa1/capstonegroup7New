package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.factory.MaintenanceFactory;
import za.ac.cput.service.MaintenanceService;
import za.ac.cput.service.impl.MaintenanceServiceImpl;

import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

 @Autowired
private  MaintenanceService  maintenanceService;

@PostMapping("/create")
 public Maintenance create(@RequestBody Maintenance maintenance){
 Maintenance newMaintenance = MaintenanceFactory.createMaintenance(maintenance.getDescription(),maintenance.getRequestDate());
return maintenanceService.create(newMaintenance);

}
    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable String requestId){
        return maintenanceService.delete(requestId);
    }
    @GetMapping("/all")
    Set<Maintenance> getAll(){
        return maintenanceService.getAll();
    }



}






