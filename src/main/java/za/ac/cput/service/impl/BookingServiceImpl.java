package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;
import za.ac.cput.repository.BookingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository repository;
    @Autowired
    BookingServiceImpl(BookingRepository repository){
        this.repository = repository;
    }

    @Override
    public Booking create(Booking booking) {
        return this.repository.save(booking);
    }

    @Override
    public Booking read(String bookingID) {
        return this.repository.findById(bookingID).orElse(null);
    }

    @Override
    public Booking update(Booking booking) {
        if(this.repository.existsById(booking.getBookingId())){
            return this.repository.save(booking);
        }
        return null;
    }

    @Override
    public boolean delete(String bookingID) {
        if(this.repository.existsById(bookingID)){
            this.repository.deleteById(bookingID);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getall() {
        return this.repository.findAll().stream().collect(Collectors.toList());
    }
}
