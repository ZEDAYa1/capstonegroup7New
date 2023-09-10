package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.PropertyFactory;
import za.ac.cput.service.PropertyService;

import java.util.Set;

@RestController
@RequestMapping("/property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/create")
    public Property create(@RequestBody Property property){
        return propertyService.create(property);
    }

    @GetMapping("/read/{id}")
    public Property read(@PathVariable String id){
        return propertyService.read(id);
    }

    @PostMapping("/update")
    public Property update(@RequestBody Property property){
        return propertyService.update(property);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return propertyService.delete(id);
    }

    @GetMapping({"/getAll"})
    public List<Property> getAll(){
        return propertyService.getAll();
    }
}


