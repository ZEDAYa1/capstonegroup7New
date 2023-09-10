package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Property;
import za.ac.cput.repository.PropertyRepository;
import za.ac.cput.service.PropertyService;

import java.util.List;
import java.util.Set;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository repository;

    @Autowired
    private PropertyServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }


    @Override
    public Property create(Property property) {
        return this.repository.save(property);
    }

    @Override
    public Property read(String propertyID) {
        return this.repository.findById(propertyID).orElse(null);
    }

    @Override
    public Property update(Property property) {
        if (this.repository.existsById(property.getPropertyID()))
            return this.repository.save(property);
        return null;
    }

    @Override
    public boolean delete(String propertyID) {
        if (this.repository.existsById(propertyID)) {
            this.repository.deleteById(propertyID);
            return true;
        }
        return false;
    }

    @Override
    public List<Property> getAll() {
        return this.repository.findAll();
    }
}
