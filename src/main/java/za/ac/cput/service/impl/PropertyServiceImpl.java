package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Property;
import za.ac.cput.domain.Tenant;
import za.ac.cput.repository.PropertyRepository;
import za.ac.cput.service.PropertyService;

import java.util.Set;

@Service
public class PropertyServiceImpl implements PropertyService {
    private static PropertyServiceImpl service = null;
    private PropertyRepository repository = null;

    private PropertyServiceImpl(){
        if(repository == null){
            repository = PropertyServiceImpl.getRepository();
        }
    }

   private static PropertyRepository getRepository(){
        return PropertyRepository.getRepository();
   }

   public static PropertyServiceImpl getService(){
        if (service==null){
            service = new PropertyServiceImpl();
        }
        return service;
   }

   @Override
    public Property create(Property property){
        Property created = repository.create(property);
        return created;
   }

    @Override
    public Property read(String id) {
        Property readProperty = repository.read(id);
        return readProperty;
    }

    @Override
    public Property update(Property property) {
        Property updated = repository.update(property);
        return updated;
    }

    @Override
    public boolean delete(String propertyID){
        boolean success = repository.delete(propertyID);
        return success;
    }

    @Override
    public Set<Property> findAll() {
        return repository.getAll();
    }

    @Override
    public Set<Property> getAll(){
        return repository.getAll();
    }
}