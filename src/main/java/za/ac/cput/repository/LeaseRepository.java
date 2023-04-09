package za.ac.cput.repository;

import za.ac.cput.domain.Lease;

import java.util.HashSet;
import java.util.Set;
public class LeaseRepository implements iLeaseRepository{
    private static LeaseRepository repository = null;
    private Set<Lease> leaseDB = new HashSet<Lease>();

    public static LeaseRepository getRepository(){
        if(repository == null){
            repository = new LeaseRepository();
        }
        return repository;
    }

    @Override
    public Lease create(Lease lease) {
        boolean success = leaseDB.add(lease);
        if(!success)
            return null;
        return lease;
    }

    @Override
    public Lease read(String leaseId) {
        Lease lease = leaseDB.stream()
                .filter(c -> c.getLeaseId().equals(leaseId))
                .findAny()
                .orElse(null);
        return lease;
    }

    @Override
    public Lease update(Lease lease) {
        Lease oldLease = read(lease.getLeaseId());
        if(oldLease != null){
            leaseDB.remove(oldLease);
            leaseDB.add(lease);
        }
        return null;
    }

    @Override
    public boolean delete(String leaseId) {
        Lease deleteLease = read(leaseId);
        if(deleteLease == null)
            return false;
        leaseDB.remove(deleteLease);
        return true;
    }

    @Override
    public Set<Lease> getAll() {
        return null;
    }
}
