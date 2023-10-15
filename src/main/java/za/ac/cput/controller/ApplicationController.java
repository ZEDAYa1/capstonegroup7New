package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Application;
import za.ac.cput.factory.ApplicationFactory;
import za.ac.cput.service.ApplicationService;
import java.util.Set;

/* ApplicationController.java
 *  This is a controller class for Application entity.
 *  Zachariah Matsimella 220097429
 */
@RestController
@RequestMapping("capstonegroup7/application")
@Slf4j
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }

    @PostMapping("/save")
    public ResponseEntity<Application> save(@RequestBody Application application){
        log.info("Save request: {}", application);
        Application validatedApplication;
        try{
            validatedApplication = ApplicationFactory.createApplication(
                    application.isBankStatement(),
                    application.isPaySlip(),
                    application.getStatus(),
                    application.getAdress(),
                    application.getEmail(),
                    application.getContactNumber(),
                    application.getId(),
                    application.getFirstName(),
                    application.getLastName(),
                    application.getApplicationDate(),
                    application.getPropertyId(),
                    application.getTenantId(),
                    application.isCopyOfId(),
                    application.getReferences()
            );
        } catch (IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Application save = applicationService.save(validatedApplication);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Application> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Application application = this.applicationService.read(id);
        return ResponseEntity.ok(application);
    }

    @PostMapping("/update")
    public Application update(@RequestBody Application application){
        return applicationService.update(application);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.applicationService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Application>> findAll(){
        Set<Application> application = this.applicationService.findAll();
        return ResponseEntity.ok(application);
    }

}
