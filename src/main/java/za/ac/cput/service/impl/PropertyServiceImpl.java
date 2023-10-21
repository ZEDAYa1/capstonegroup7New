package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Property;
import za.ac.cput.domain.Tenant;
import za.ac.cput.repository.IPropertyRepository;
import za.ac.cput.service.PropertyService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final IPropertyRepository repository;

    @Autowired
    public PropertyServiceImpl(IPropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Property save(Property property) {
        return this.repository.save(property);
    }

    @Override
    public Property read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Property update(Property property) {
        if (this.repository.existsById(property.getPropertyId())) {
            return this.repository.save(property);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        if (this.repository.existsById(s)) {
            this.repository.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public Set<Property> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

//    @Override
//    public Set<Property> getAll() {
//        return null;
//    }
}

