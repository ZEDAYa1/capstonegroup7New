package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Features;
import za.ac.cput.factory.FeaturesFactory;
import za.ac.cput.service.FeaturesService;


import java.util.Set;

@RestController
@RequestMapping("/features")
public class FeaturesController {
    @Autowired
    private FeaturesService featuresService;

    @PostMapping("/create")
    public Features create(@RequestBody Features features){
        Features newFeatures = FeaturesFactory.buildFeatures(features.getPool(), features.isKitchen(), features.isGarage(), features.getSize(), features.getBathrooms(), features.getBedrooms(), features.isLounge(), features.isLaundry());
        return featuresService.create(newFeatures);

    }
    @DeleteMapping("/delete/{id}")
    boolean delete(@PathVariable String requestId){
        return featuresService.delete(requestId);
    }
    @GetMapping("/all")
    Set<Features> getAll(){
        return featuresService.getAll();
    }



}






