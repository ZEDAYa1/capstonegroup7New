package za.ac.cput.repository;

import za.ac.cput.domain.Lease;

import java.util.Set;
public interface iLeaseRepository extends iRepository<Lease, String>{
    public Set<Lease> getAll();
}
