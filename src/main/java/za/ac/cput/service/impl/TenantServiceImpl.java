/*
 * TenantServiceImpl.java
 * This is the TenantService Implementation class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 20 June 2023
 * */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tenant;
import za.ac.cput.repository.TenantRepository;
import za.ac.cput.service.TenantService;

import java.util.List;
import java.util.Set;

@Service
public class TenantServiceImpl implements TenantService {
    private TenantRepository repository;

    @Autowired
    private TenantServiceImpl(TenantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tenant create(Tenant tenant) {
        return this.repository.save(tenant);
    }

    @Override
    public Tenant read(String tenantID) {
        return this.repository.findById(tenantID).orElse(null);
    }

    @Override
    public Tenant update(Tenant tenant) {
        if (this.repository.existsById(tenant.getTenantID())) {
            return this.repository.save(tenant);
        }
        return null;
    }

    @Override
    public boolean delete(String tenantID) {
        if (this.repository.existsById(tenantID)) {
            this.repository.deleteById(tenantID);
            return true;
        }
        return false;
    }

    @Override
    public List<Tenant> getAll() {
        return this.repository.findAll();
    }
}
