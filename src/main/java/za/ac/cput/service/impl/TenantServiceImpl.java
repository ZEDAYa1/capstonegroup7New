/*
 * TenantServiceImpl.java
 * This is the TenantService Implementation class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 20 June 2023
 * */
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Tenant;
import za.ac.cput.repository.TenantRepository;
import za.ac.cput.service.TenantService;

import java.util.Set;

@Service
public class TenantServiceImpl implements TenantService{
    private static TenantServiceImpl service = null;
    private TenantRepository repository = null;

    private TenantServiceImpl(){
        if (repository == null) {
            repository = TenantServiceImpl.getRepository();
        }
    }

    private static TenantRepository getRepository() {
        return TenantRepository.getRepository();
    }


    public static TenantServiceImpl getService(){
        if (service == null){
            service = new TenantServiceImpl();
        }
        return service;
    }

    @Override
    public Tenant create(Tenant tenant){
        Tenant created = repository.create(tenant);
        return created;
    }

    @Override
    public Tenant read(String id) {
        Tenant readTenent = repository.read(id);
        return readTenent;
    }

    @Override
    public Tenant update(Tenant tenant) {
        Tenant updated = repository.update(tenant);
        return updated;
    }

    @Override
    public boolean delete(String tenantID){
        boolean success = repository.delete(tenantID);
        return success;
    }

    @Override
    public Set<Tenant> findAll() {
        return repository.getAll();
    }

    @Override
    public Set<Tenant> getAll(){
        return repository.getAll();
    }
}