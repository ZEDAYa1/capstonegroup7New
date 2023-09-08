package za.ac.cput.repository;

import za.ac.cput.domain.Property;

import java.util.Set;

public interface IPropertyRepository extends IRepository<Property, String>{
    public Set<Property> getAll();
}
