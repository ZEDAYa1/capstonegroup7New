package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Application;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/* Application.java
 *  This is a factory test class for Application entity.
 *  Zachariah Matsimella 220097429
 */
public class ApplicationFactoryTest {
    @Test
    public void test(){
        Application application = ApplicationFactory.createApplication(true, true, "Accepted", "20 Memory Lane", "James@gmail.com"
                , "0874563254", 0010224567, "James", "Clarke", LocalDate.parse("2020-06-06"), "25", "12"
                , true, "References here.");
        System.out.println(application.toString());
        assertNotNull(application);
    }
    @Test
    public void test_fail(){
        Application application1 = ApplicationFactory.createApplication(true, true, "Accepted", "20 Memory Lane", "James@gmail.com"
                , "0874563254", 0010224567, "James", "Clarke", LocalDate.parse("2020-06-06"), "25", "12"
                , true, "References here.");
        Application application2 = ApplicationFactory.createApplication(true, true, "Accepted", "20 Memory Lane", "James@gmail.com"
                , "0874563254", 0010224567, "James", "Clarke", LocalDate.parse("2020-06-06"), "25", "12"
                , true, "References here.");
        System.out.println("Application 1: "+ application1);
        System.out.println("Application 2: "+ application2);
        assertEquals(application1, application2);

    }
    @Test
    public void testEquality(){
        Application application1 = ApplicationFactory.createApplication(true, true, "Accepted", "20 Memory Lane", "James@gmail.com"
                , "0874563254", 0010224567, "James", "Clarke", LocalDate.parse("2020-06-06"), "25", "12"
                , true, "References here.");
        Application application2 = application1;
        assertEquals(application1, application2);

    }


    @Test
    public void testIdentity(){
        Application application1 = ApplicationFactory.createApplication(true, true, "Accepted", "20 Memory Lane", "James@gmail.com"
                , "0874563254", 0010224567, "James", "Clarke", LocalDate.parse("2020-06-06"), "25", "12"
                , true, "References here.");
        Application application2 = ApplicationFactory.createApplication(true, true, "Pending", "36 Cherry Lane", "XALL@gmail.com"
                , "0645879856", 990615426, "Xavier", "Leander", LocalDate.parse("2019-04-24"), "25", "06"
                , true, "References here.");
        assertNotSame(application1, application2);

    }


    @Test
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    public void testTimeout(){
        System.out.println("Timeout passed");


    }


    @Test
    @Disabled
    public void testdisabled() {

        System.out.println("test disabled");
    }
}
