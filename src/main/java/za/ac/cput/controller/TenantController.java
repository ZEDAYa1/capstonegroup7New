package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;
import za.ac.cput.service.TenantService;

import java.util.Set;

@RestController
@RequestMapping("/capstonegroup7/tenant/")
@Slf4j
public class TenantController {
    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/save")
    public ResponseEntity<Tenant> save(@RequestBody Tenant tenant) {
        log.info("Save request: {}", tenant);
        Tenant validatedTenant;
        try {
            validatedTenant = TenantFactory.createTenant(tenant.getTenantId(), tenant.getLeaseId(), tenant.getFirstName(),tenant.getLastName());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Tenant save = tenantService.save(validatedTenant);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.tenantService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Tenant> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Tenant tenant = this.tenantService.read(id);
        return ResponseEntity.ok(tenant);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Tenant>> findAll() {
        Set<Tenant> tenants = this.tenantService.findAll();
        return ResponseEntity.ok(tenants);
    }
}
