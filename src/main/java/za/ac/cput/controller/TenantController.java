package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Tenant;
import za.ac.cput.service.TenantService;

import java.util.Set;

@RestController
@RequestMapping("/tenants")
public class TenantController {
    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("save")
    public Tenant createTenant(@RequestBody Tenant tenant) {
        return tenantService.save(tenant);
    }

    @GetMapping("read/{id}")
    public Tenant getTenant(@PathVariable String id) {
        return tenantService.read(id);
    }

    @DeleteMapping("delete/{id}")
    public boolean deleteTenant(@PathVariable String id) {
        return tenantService.delete(id);
    }
    @GetMapping("all")
    public Set<Tenant> findAllTenant() {
        return tenantService.findAll();
    }
}
