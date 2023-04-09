package za.ac.cput.repository;


import za.ac.cput.domain.Client;
import za.ac.cput.domain.Property;

import java.util.HashSet;
import java.util.Set;

public class PropertyRepository implements iPropertyRepository {
    private static PropertyRepository repository = null;
    private Set<Property> propertyDB = null;

    private PropertyRepository(){
        propertyDB = new HashSet<Property>();
    }

    public static PropertyRepository getRepository(){
        if (repository == null) {
            repository = new PropertyRepository();
        }
        return repository;
    }
    @Override
    public Property create(Property property) {
        boolean success = propertyDB.add(property);
        if(!success)
            return null;
        return property;
    }

    @Override
    public Property read(String propertyID) {
        Property property = propertyDB.stream()
                .filter(c -> c.getPropertyID().equals(propertyID))
                .findAny()
                .orElse(null);
        return property;
    }

    @Override
    public Property update(Property property) {
        Property oldProperty = read(property.getPropertyID());
        if( oldProperty != null){
            propertyDB.remove(oldProperty);
            propertyDB.add(property);
            return property;
        }
        return null;
    }

    @Override
    public boolean delete(String propertyID) {
        Property propertyToDelete = read(propertyID);
        if(propertyToDelete == null)
            return false;
        propertyDB.remove(propertyToDelete);
        return true;
    }

    @Override
    public Set<Property> getAll() {
        return propertyDB;
    }
}