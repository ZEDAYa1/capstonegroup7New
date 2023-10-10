package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;
import za.ac.cput.service.PropertyService;

import java.util.Set;

@RestController
@RequestMapping("capstonegroup7/property/")
@Slf4j
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/save")
    public ResponseEntity<Property> save(@RequestBody Property property) {
        log.info("Save request: {}", property);
        Property validatedProperty;
        try {
            validatedProperty = PropertyFactory.createProperty(
                    property.getAddress(),
                    property.getRentAmount(),
                    property.getDescription()
            );
        } catch (IllegalArgumentException e) {
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Property save = propertyService.save(validatedProperty);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        log.info("Delete request: {}", id);
        this.propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Property> readId(@PathVariable String id) {
        log.info("Read request: {}", id);
        Property property = this.propertyService.read(id);
        return ResponseEntity.ok(property);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<Property>> findAll() {
        Set<Property> properties = this.propertyService.findAll();
        return ResponseEntity.ok(properties);
    }
}
