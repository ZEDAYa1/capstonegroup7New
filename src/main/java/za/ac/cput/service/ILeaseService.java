package za.ac.cput.service;

import za.ac.cput.domain.Lease;

import java.util.List;


public interface ILeaseService extends IService <Lease, String> {
    public List<Lease> getAll();
}
