package za.ac.cput.service;

import za.ac.cput.domain.Property;

import java.util.Set;
import java.util.List;

public interface PropertyService extends IService <Property, String>{
    List<Property> getAll();

}
