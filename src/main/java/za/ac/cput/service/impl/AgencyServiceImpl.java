/* AgencyServiceImpl.java
 Service class for Agency
 Author: Zachary Carstens (221054022)
 Date: 18 June 2023
*/
package za.ac.cput.service.impl;

import za.ac.cput.domain.Agency;
import za.ac.cput.service.AgencyService;
import java.util.Set;

public class AgencyServiceImpl implements AgencyService {

    private static AgencyServiceImpl service = null;

    private static AgencyRepository repository = null;

    private AgencyServiceImpl() {
        repository = AgencyRepository.getRepository();
    }

    public static AgencyServiceImpl getService() {
        if (service == null) {
            service = new AgencyServiceImpl();
        }
        return service;
    }

    @Override
    public Agency create(Agency agency) {
        Agency created = repository.create(agency);
        return created;
    }

    @Override
    public Agency read(String agencyId) {
        Agency readAgency = repository.read(agencyId);
        return readAgency;
    }

    @Override
    public Agency update(Agency agency) {
        Agency updated = repository.update(agency);
        return updated;
    }

    @Override
    public boolean delete(String agencyId) {
        boolean success = repository.delete(agencyId);
        return success;
    }

    @Override
    public Set<Agency> getAll() {
        return repository.getAll();
    }

}
