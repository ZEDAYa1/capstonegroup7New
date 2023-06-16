package za.ac.cput.repository;

import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/* BookingRepositoryTest.java
 *  This is a test for Booking repository entity
 *  Zachariah Matsimella 220097429
 */
public class BookingRepositoryTest {
    private static BookingRepository repository = BookingRepository.getRepository();
    private static Booking booking = new Booking.Builder()
            .setDate(new Date(2023, 04, 25))
            .setTime("4pm")
            .setAddress("19 Pou Street, Malmesbury")
            .build();

    @Test
    void a_create(){
        Booking newBooking = repository.create(booking);
        assertNotNull(newBooking);
        System.out.println(newBooking);
    }

    @Test
    void b_read(){
        Booking readBooking = repository.read(booking.getBookingId());
        assertNotNull(readBooking);
        System.out.println(readBooking);
    }

    @Test
    void c_update(){
        Booking updateBooking = new Booking.Builder()
                .copy(booking)
                .setDate(new Date(2023, 03, 22))
                .setTime("2pm")
                .setAddress("22 Boo Kant Street, Brackenfell")
                .build();
        assertNotNull(updateBooking);
        System.out.println(updateBooking);
    }

    @Test
    void e_delete(){
        boolean successful = repository.delete(booking.getBookingId());
        assertTrue(successful);
        System.out.println(successful);
    }

    @Test
    void d_getAll(){
        System.out.println("Get all bookings");
        System.out.println(repository.getAll());
    }
}
