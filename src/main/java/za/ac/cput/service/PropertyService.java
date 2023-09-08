package za.ac.cput.service;

import za.ac.cput.domain.Property;

import java.util.Set;

public interface PropertyService extends IService <Property, String>{
    Set<Property> getAll();

}
