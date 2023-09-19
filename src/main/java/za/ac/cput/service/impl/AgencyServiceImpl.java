/* AgencyServiceImpl.java
 Service class for Agency
 Author: Zachary Carstens (221054022)
 Date: 18 June 2023
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Agency;
import za.ac.cput.repository.IAgencyRepository;
import za.ac.cput.service.AgencyService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AgencyServiceImpl implements AgencyService {

    private final IAgencyRepository repository;

    @Autowired
    public AgencyServiceImpl(IAgencyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Agency save(Agency agency) {
        return this.repository.save(agency);
    }

    @Override
    public Agency read(String agencyId) {
        return this.repository.findById(agencyId).orElse(null);
    }

    @Override
    public boolean delete(String agencyId) {
        if (this.repository.existsById(agencyId)) {
            this.repository.deleteById(agencyId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Agency> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Agency> getAll() {
        return null;
    }
}

