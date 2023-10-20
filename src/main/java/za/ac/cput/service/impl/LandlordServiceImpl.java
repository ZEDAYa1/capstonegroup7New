/* LandlordServiceImpl.java
 Service class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 18 June 2023
*/
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Landlord;
import za.ac.cput.repository.ILandlordRepository;
import za.ac.cput.service.LandlordService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LandlordServiceImpl implements LandlordService {

    private final ILandlordRepository repository;

    @Autowired
    public LandlordServiceImpl(ILandlordRepository repository) {
        this.repository = repository;
    }

    @Override
    public Landlord save(Landlord landlord) {
        return this.repository.save(landlord);
    }

    @Override
    public Landlord read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Landlord update(Landlord landlord) {
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
    public Set<Landlord> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

//    @Override
//    public Set<Landlord> getAll() {
//        return null;
//    }
}
