package za.ac.cput.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.repository.IMaintenanceRepository;
import za.ac.cput.service.MaintenanceService;

import java.util.Set;
//sonwabiso Moni
//219275041
@Service
public class MaintenanceServiceImpl implements MaintenanceService {


    private IMaintenanceRepository repository;

    @Autowired
    private MaintenanceServiceImpl(IMaintenanceRepository repository) {
        this.repository = repository;
    }


    @Override
    public Maintenance create(Maintenance maintenance){
         return this.repository.save(maintenance);
    }

    @Override
    public boolean delete(String requestId){
        if (this.repository.existsById(requestId)) {
            this.repository.deleteById(requestId);
            return true;
        }
        return false;
    }

    @Override
    public Maintenance save(Maintenance maintenance) {
        return this.repository.save(maintenance);
    }
    @Override
    public Maintenance read(String s) {
        return this.repository.findById(s).orElse(null);
    }
    @Override
    public Set<Maintenance> getAll() {
        return null;
    }
}
