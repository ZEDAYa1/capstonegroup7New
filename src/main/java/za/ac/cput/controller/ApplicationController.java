/* ApplicationController.java
 *  This is a controller class for Application entity.
 *  Zachariah Matsimella 220097429
 */
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Application;
import za.ac.cput.service.ApplicationService;

import java.util.Set;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("save")
    public Application createApplication(@RequestBody Application application) {
        return applicationService.save(application);
    }


    @GetMapping("read/{id}")
    public Application getApplication(@PathVariable String id) {
        return applicationService.read(id);
    }


    @DeleteMapping("delete/{id}")
    public boolean deleteApplication(@PathVariable String id) {
        return applicationService.delete(id);
    }


    @GetMapping("all")
    public Set<Application> findAllApplications() {
        return applicationService.findAll();
    }
}

