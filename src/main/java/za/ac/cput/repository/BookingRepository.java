package za.ac.cput.repository;

import za.ac.cput.domain.Booking;

import java.util.HashSet;
import java.util.Set;
public class BookingRepository implements iBookingRepository {
    private static BookingRepository repository = null;
    private Set<Booking> bookingDB = new HashSet<Booking>();

    public static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    @Override
    public Booking create(Booking booking) {
        boolean success = bookingDB.add(booking);
        if (!success)
            return null;
        return booking;
    }

    @Override
    public Booking read(String bookingId) {
        Booking booking = bookingDB.stream()
                .filter(c -> c.getBookingId().equals(bookingId))
                .findAny()
                .orElse(null);
        return booking;
    }

    @Override
    public Booking update(Booking booking) {
        Booking oldBooking = read(booking.getBookingId());
        if (oldBooking != null) {
            bookingDB.remove(oldBooking);
            bookingDB.add(booking);
        }
        return null;
    }

    @Override
    public boolean delete(String bookingId){
        Booking deleteBooking = read(bookingId);
        if(deleteBooking == null)
            return false;
        bookingDB.remove(deleteBooking);
        return true;
    }

    @Override
    public Set<Booking> getall() {
        return bookingDB;
    }

    @Override
    public Set<Booking> getAll() {
        return bookingDB;
    }
}
