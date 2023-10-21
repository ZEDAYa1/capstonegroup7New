package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import za.ac.cput.domain.Features;
import za.ac.cput.factory.FeaturesFactory;
import za.ac.cput.service.FeaturesService;

import java.util.Set;

@RestController
@RequestMapping("capstonegroup7/features/")
@Slf4j
public class FeaturesController {

    private final FeaturesService featuresService;

    @Autowired
    public FeaturesController(FeaturesService featuresService) {
        this.featuresService = featuresService;
    }

    @PostMapping("save")
    public ResponseEntity<Features> save(@RequestBody Features features) {
        log.info("Save request: {}", features);
        Features validatedFeatures;
        try {
            validatedFeatures = FeaturesFactory.buildFeatures(features.getPool(), features.isKitchen(), features.isGarage(), features.getSize(), features.getBathrooms(), features.getBedrooms(), features.isLounge(), features.isLaundry());
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Features save = featuresService.save(validatedFeatures);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.featuresService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Features> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Features features= this.featuresService.read(id);
        return ResponseEntity.ok(features);
    }

    @GetMapping("all")
    public ResponseEntity<Set<Features>> findAll() {
        Set<Features> features = this.featuresService.findAll();
        return ResponseEntity.ok(features);
    }
}