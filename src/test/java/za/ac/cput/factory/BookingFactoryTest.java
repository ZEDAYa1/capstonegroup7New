package za.ac.cput.factory;
/* BookingFactoryTest.java
*  This is a test for Booking entity
*  Zachariah Matsimella 220097429
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class BookingFactoryTest {

    @Test
    public void test1(){

        Booking booking = new Booking.Builder()
                .setDate(new Date(2023, 04, 25))
                .setTime("4pm")
                .setAddress("19 Pou Street, Malmesbury")
                .build();
        System.out.println(booking);
        assertNotNull(booking);
    }

    @Test
    public void test2(){
        Booking booking = BookingFactory.createBooking(new Date(2023, 03, 15), "3pm", "20 Dirkie Uis Street, Malmesbury");
        System.out.println(booking.toString());
        assertNotNull(booking);
    }

    @Test
    public void failTest(){
        Booking booking = BookingFactory.createBooking(null, "", "");
    }
}
