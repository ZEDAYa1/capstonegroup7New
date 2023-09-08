package za.ac.cput.controller;

/*
 * TenantController.java
 * This is the TenantController class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 20 August 2023
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;
import za.ac.cput.service.TenantService;

import java.util.Set;

@RestController
@RequestMapping("/tenant")
public class TenantController {
    @Autowired
    private TenantService tenantService;

//    @RequestMapping({"/", "/home"})
//     String home() {
//        return "Hello World!";
//    }

    @PostMapping("/create")
    public Tenant create(@RequestBody Tenant tenant){
        Tenant firstTenant = TenantFactory.createTenant(tenant.getFirstName(), tenant.getLastName(),tenant.getEmail(),tenant.getContactNumber());
        return tenantService.create(firstTenant);
    }

    @GetMapping("/read/{id}")
    public Tenant read(@PathVariable String id){
        return tenantService.read(id);
    }

    @PostMapping("/update")
    public Tenant update(@RequestBody Tenant tenant){
        return tenantService.update(tenant);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id ){
        return tenantService.delete(id);
    }

    @GetMapping({"/getAll"})
    public Set<Tenant> getAll(){
        return tenantService.getAll();
    }
}
