package za.ac.cput.repository;

import za.ac.cput.domain.Tenant;

import java.util.Set;

public interface ITenantRepository extends IRepository<Tenant, String> {
    public  Set<Tenant> getAll();
}
