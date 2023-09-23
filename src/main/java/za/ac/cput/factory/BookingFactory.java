package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

public class BookingFactory {
    public static Booking createBooking(LocalDate date, String time, String address){
        if(Helper.isDateNull(date)
        ||Helper.isNullOrEmpty(time)
        ||Helper.isNullOrEmpty(address)){
            return null;
        }


        String bookingId = Helper.generateId();

        Booking booking = new Booking.Builder().setBookingId(bookingId)
                .setDate(date)
                .setTime(time)
                .setAddress(address)
                .build();
        return booking;
    }
}
