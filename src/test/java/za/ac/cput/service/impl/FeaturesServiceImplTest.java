package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Features;
import za.ac.cput.factory.FeaturesFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class FeaturesServiceImplTest {

    private static Features features= FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);
    private static Features features2= FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);

    private static Features features3= FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);

    @Autowired
    private FeaturesServiceImpl service;

    @Test
    void a_save() {
        Features created = service.save(features);
        assertEquals(features.getPropertyID(), created.getPropertyID());
        System.out.println("Created: "+ created);

        Features created2 = service.save(features2);
        assertEquals(features2.getPropertyID(), created2.getPropertyID());
        System.out.println("Created: "+ created2);

        Features created3 = service.save(features3);
        assertEquals(features3.getPropertyID(), created3.getPropertyID());
        System.out.println("Created: "+ created3);
    }
    @Test
    void b_read() {
        Features read = service.read(features.getPropertyID());
        assertEquals(read.getPropertyID(), features.getPropertyID());
        System.out.println("Show features: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(features.getPropertyID());
        assertTrue(success);
        System.out.println("Delete fatuires: " + success);
    }

    @Test
    void getAll() {
     System.out.println("Show All:");
     System.out.println(service.getAll());

    }




}