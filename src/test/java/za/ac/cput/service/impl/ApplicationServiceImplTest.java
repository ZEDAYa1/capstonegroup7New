package za.ac.cput.service.impl;

import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Application;
import za.ac.cput.domain.Property;
import za.ac.cput.factory.ApplicationFactory;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/* LeaseServiceImplTest.java
 *  This is a service test for Application entity
 *  Zachariah Matsimella 220097429
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class ApplicationServiceImplTest {

    private static Application application1 = ApplicationFactory.createApplication(true, true, "Accepted", "20 Memory Lane", "James@gmail.com"
            , "0874563254", 0010224567, "James", "Clarke", LocalDate.parse("2020-06-06"), "25", "12"
            , true, "References here.");

    private static  Application application2 = ApplicationFactory.createApplication(false, true, "Pending", "36 Cherry Lane", "XALL@gmail.com"
            , "0645879856", 990615426, "Xavier", "Leander", LocalDate.parse("2019-04-24"), "25", "06"
            , true, "References here.");

    private static Application application3 = ApplicationFactory.createApplication(true, false, "Pending", "15 Lance avenue", "Mandy@gmail.com"
            , "0796542589", 991208426, "Mandisa", "Nydenga", LocalDate.parse("2021-03-14"), "08", "05"
            , true, "References here.");

    @Autowired
    private ApplicationServiceImpl service;

    @Test
    void a_save(){
        Application create1 = service.save(application1);
        assertNotNull(create1);
        System.out.println(create1);

        Application create2 = service.save(application2);
        assertNotNull(create2);
        System.out.println(create2);


        Application create3 = service.save(application3);
        assertNotNull(create3);
        System.out.println(create3);

    }

    @Test
    void b_read(){
        Application readApplication = service.read(application1.getApplicationId());
        assertEquals(readApplication.getApplicationId(), application1.getApplicationId());
        System.out.println("Reading application: "+ readApplication);
    }

    @Test
    void c_update() {
        Application updatedApplication = new Application.Builder().setEmail("XALL@email.com").build();
        Application updated = service.update(updatedApplication);
        Assert.assertNotNull(application2);
        System.out.println("updated: " + updated);
    }
    @Test
    void d_delete(){
        boolean deleteLease = service.delete(application1.getApplicationId());
        assertNotNull(!deleteLease);
        System.out.println("Deleted: "+ deleteLease);
    }

    @Test
    void e_findAll(){
        System.out.println("Find all:");
        System.out.println(service.findAll());
    }
}
