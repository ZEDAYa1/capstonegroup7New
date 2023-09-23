package za.ac.cput.service;

import za.ac.cput.domain.Lease;
import java.util.Set;


public interface LeaseService extends IService <Lease, String> {
    public Set<Lease> getAll();
}
