/* LandlordServiceImpl.java
 Service class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 18 June 2023
*/
package za.ac.cput.service.impl;

import za.ac.cput.domain.Landlord;
import za.ac.cput.repository.LandlordRepository;
import za.ac.cput.service.LandlordService;
import java.util.Set;

public class LandlordServiceImpl implements LandlordService {

    private static LandlordServiceImpl service = null;

    private static LandlordRepository repository = null;

    private LandlordServiceImpl() {
        repository = LandlordRepository.getRepository();
    }

    public static LandlordServiceImpl getService() {
        if (service == null) {
            service = new LandlordServiceImpl();
        }
        return service;
    }

    @Override
    public Landlord create(Landlord landlord) {
        Landlord created = repository.create(landlord);
        return created;
    }

    @Override
    public Landlord read(String landlordId) {
        Landlord readLandlord = repository.read(landlordId);
        return readLandlord;
    }

    @Override
    public Landlord update(Landlord landlord) {
        Landlord updated = repository.update(landlord);
        return updated;
    }

    @Override
    public boolean delete(String landlordId) {
        boolean success = repository.delete(landlordId);
        return success;
    }

    @Override
    public Set<Landlord> getAll() {
        return repository.getAll();
    }


}
