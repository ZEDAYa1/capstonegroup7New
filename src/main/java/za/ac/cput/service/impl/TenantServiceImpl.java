package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tenant;
import za.ac.cput.repository.ITenantRepository;
import za.ac.cput.service.TenantService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TenantServiceImpl implements TenantService {

    private final ITenantRepository repository;

    @Autowired
    public TenantServiceImpl(ITenantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Tenant save(Tenant tenant) {
        return this.repository.save(tenant);
    }

    @Override
    public Tenant read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Tenant update(Tenant tenant) {
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public Set<Tenant> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Tenant> getAll() {
        return null;
    }
}