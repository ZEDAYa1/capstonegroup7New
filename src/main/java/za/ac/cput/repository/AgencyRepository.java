/* AgencyRepository.java
 Repository class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Agency;
import java.util.HashSet;
import java.util.Set;

public class AgencyRepository implements IAgencyRepository {

    private static AgencyRepository repository = null;
    private Set<Agency> agencyDB = null;

    private AgencyRepository() {
        agencyDB = new HashSet<Agency>();
    }

    public static AgencyRepository getRepository() {
        if (repository == null) {
            repository = new AgencyRepository();
        }
        return repository;
    }

    @Override
    public Agency create(Agency agency) {
        boolean success = agencyDB.add(agency);
        if (!success)
            return null;
        return agency;
    }

    @Override
    public Agency read(String agencyId) {
        for (Agency a : agencyDB)
            if (a.getAgencyId().equals(agencyId))
                return a;
        return null;
    }

    @Override
    public Agency update(Agency agency) {
        Agency oldAgency = read(agency.getAgencyId());
        if (oldAgency != null) {
            agencyDB.remove(oldAgency);
            agencyDB.add(agency);
            return agency;
        }
        return null;
    }

    @Override
    public boolean delete(String agencyId) {
        Agency agencyToDelete = read(agencyId);
        if (agencyToDelete == null)
            return false;
        agencyDB.remove(agencyToDelete);
        return true;
    }

    public Set<Agency> getAll() {
        return agencyDB;
    }

}
