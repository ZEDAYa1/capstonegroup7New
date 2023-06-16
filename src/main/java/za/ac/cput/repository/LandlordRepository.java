/* LandlordRepository.java
 Repository class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 9 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Landlord;
import java.util.HashSet;
import java.util.Set;

public class LandlordRepository implements ILandlordRepository {

    private static LandlordRepository repository = null;
    private Set<Landlord> landlordDB = null;

    private LandlordRepository() {
        landlordDB = new HashSet<Landlord>();
    }

    public static LandlordRepository getRepository() {
        if (repository == null) {
            repository = new LandlordRepository();
        }
        return repository;
    }

    @Override
    public Landlord create(Landlord landlord) {
        boolean success = landlordDB.add(landlord);
        if (!success)
            return null;
        return landlord;
    }

    @Override
    public Landlord read(String landlordId) {
        for (Landlord l : landlordDB)
            if (l.getLandlordId().equals(landlordId))
                return l;
        return null;
    }

    @Override
    public Landlord update(Landlord landlord) {
        Landlord oldLandlord = read(landlord.getLandlordId());
        if (oldLandlord != null) {
            landlordDB.remove(oldLandlord);
            landlordDB.add(landlord);
            return landlord;
        }
        return null;
    }

    @Override
    public boolean delete(String landlordId) {
        Landlord landlordToDelete = read(landlordId);
        if (landlordToDelete == null)
            return false;
        landlordDB.remove(landlordToDelete);
        return true;
    }

    public Set<Landlord> getAll() {
        return landlordDB;
    }

}
