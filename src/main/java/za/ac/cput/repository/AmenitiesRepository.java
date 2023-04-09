package za.ac.cput.repository;
import za.ac.cput.domain.Amenities;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class AmenitiesRepository implements iAmenitiesRepository {
    private static AmenitiesRepository repository = null;
    private Set<Amenities> amenitiesDB = null;

    private AmenitiesRepository() {
        amenitiesDB = new HashSet<Amenities>();
    }

    public static AmenitiesRepository getRepository() {
        if (repository == null) {
            repository = new AmenitiesRepository();


        }

        return repository;

    }

    @Override
    public Amenities create(Amenities amenities) {
        boolean success = amenitiesDB.add(amenities);
        if (!success)
            return null;
        return amenities;


    }

    @Override
    public Amenities read(String PropertyID) {
        Amenities amenities = amenitiesDB.stream()
                .filter(a->a.getPropertyID().equals(PropertyID))
                .findAny()
                .orElse(null);

        return amenities;

    }

    @Override
    public Amenities update(Amenities amenities) {
        Amenities oldAmenities=read(amenities.getPropertyID());
        if(oldAmenities != null){
          amenitiesDB.remove(oldAmenities);
          amenitiesDB.add(amenities);
            return amenities;
        }

        return null;
    }
@Override
public boolean delete(String PropertyID){
Amenities amenitiesToDelete = read(PropertyID) ;
if(amenitiesToDelete==null)
 return false;
amenitiesDB.remove(amenitiesToDelete);
return true;


}

@Override
public Set<Amenities> getAll(){return amenitiesDB;}





}











