package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Features;
import za.ac.cput.repository.IFeaturesRepository;
import za.ac.cput.service.FeaturesService;

import java.util.Set;
import java.util.stream.Collectors;
//sonwabiso Moni
//219275041
@Service
public class FeaturesServiceImpl implements FeaturesService {
private IFeaturesRepository repository;
@Autowired
private FeaturesServiceImpl(IFeaturesRepository repository) {
    this.repository = repository;
}

@Override
    public Features create(Features features){
    return this.repository.save(features);
}


    @Override
    public Features save(Features features) {
        return this.repository.save(features);
    }

    @Override
    public Features read(String s) {
        return this.repository.findById(s).orElse(null);
    }

    @Override
    public Features update(Features features) {
        return null;
    }

    @Override
    public boolean delete(String propertyId){
    if (this.repository.existsById(propertyId)) {
        this.repository.deleteById(propertyId);
        return true;
    }
    return false;
}

    @Override
    public Set<Features> findAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

//    @Override
//    public Set<Features> getAll() {
//        return null;
//    }


}
