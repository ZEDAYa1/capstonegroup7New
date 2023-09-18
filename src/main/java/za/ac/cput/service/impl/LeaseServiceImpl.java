package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Lease;
import za.ac.cput.service.LeaseService;
import za.ac.cput.repository.ILeaseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaseServiceImpl implements LeaseService {
    private ILeaseRepository repository;
    @Autowired
    LeaseServiceImpl(ILeaseRepository repository){
        this.repository = repository;
    }

    @Override
    public Lease create(Lease lease) {
        return this.repository.save(lease);
    }

    @Override
    public Lease read(String leaseID) {
        return this.repository.findById(leaseID).orElse(null);
    }

    @Override
    public Lease update(Lease lease) {
        if(this.repository.existsById(lease.getLeaseId())) {
            this.repository.save(lease);
        }
        return null;
    }

    @Override
    public boolean delete(String leaseID) {
        if(this.repository.existsById(leaseID)){
            this.repository.deleteById(leaseID);
            return true;
        }
        return false;
    }

    @Override
    public List<Lease> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toList());
    }
}
