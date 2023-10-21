package za.ac.cput.service;

import za.ac.cput.domain.Maintenance;

import java.util.Set;
//sonwabiso Moni
//219275041
public interface MaintenanceService {

    Maintenance update(Maintenance maintenance);

    boolean delete(String requestId);

    Maintenance save(Maintenance maintenance);

    Maintenance read(String s);

    Set<Maintenance> findAll();
//    Maintenance create(Maintenance maintenance);
//
//    boolean delete(String requestId);
//
//    Set<Maintenance> getAll();
//
//    Set<Agent> findAll();


}
