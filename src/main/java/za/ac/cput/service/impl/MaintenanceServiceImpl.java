package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.repository.IMaintenanceRepository;
import za.ac.cput.service.MaintenanceService;

import java.util.Set;
import java.util.stream.Collectors;
//sonwabiso Moni
//219275041
@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    private final IMaintenanceRepository repository;

    @Autowired
    public MaintenanceServiceImpl(IMaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return this.repository.save(maintenance);
    }

    @Override
    public Maintenance read(String s) {
        return this.repository.findById(s).orElse(null);
    }

//    @Override
//    public Maintenance update(Maintenance maintenance) {
//        return null;
//    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public Set<Maintenance> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

