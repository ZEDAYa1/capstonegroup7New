package za.ac.cput.repository;

import za.ac.cput.domain.Tenant;

import java.util.HashSet;
import java.util.Set;

public class TenantRepository implements ITenantRepository {
    private static TenantRepository repository = null;
    private Set<Tenant> tenantDB = null;

    private TenantRepository(){
        tenantDB = new HashSet<Tenant>();
    }

    public static TenantRepository getRepository(){
        if (repository == null) {
            repository = new TenantRepository();
        }
        return repository;
    }
    @Override
    public Tenant create(Tenant tenant) {
        boolean success = tenantDB.add(tenant);
        if(!success)
            return null;
        return tenant;
    }

    @Override
    public Tenant read(String TenantID) {
        Tenant tenant = tenantDB.stream()
                .filter(c -> c.getTenantID().equals(TenantID))
                .findAny()
                .orElse(null);
        return tenant;
    }

    @Override
    public Tenant update(Tenant tenant) {
        Tenant oldTenant = read(tenant.getTenantID());
        if( oldTenant != null){
            tenantDB.remove(oldTenant);
            tenantDB.add(tenant);
            return tenant;
        }
        return null;
    }

    @Override
    public boolean delete(String tenantID) {
        Tenant tenantToDelete = read(tenantID);
         if(tenantToDelete == null)
             return false;
         tenantDB.remove(tenantToDelete);
        return true;
    }

    @Override
    public Set<Tenant> getAll() {
        return tenantDB;
    }
}