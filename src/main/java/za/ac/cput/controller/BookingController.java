package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Booking;
import za.ac.cput.factory.BookingFactory;
import za.ac.cput.service.BookingService;
import java.util.Set;

@RestController
@RequestMapping("capstonegroup7/booking")
@Slf4j
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @PostMapping("save")
    public ResponseEntity<Booking> save(@RequestBody Booking booking){
        log.info("Save request: {}", booking);
        Booking validatedBooking;
        try{
            validatedBooking = BookingFactory.createBooking(
                    booking.getBookingId(),
                    booking.getDate(),
                    booking.getTime(),
                    booking.getAddress()
                    );
        } catch (IllegalArgumentException e){
            log.info("Save request error: {}", e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Booking save = bookingService.save(validatedBooking);
        return ResponseEntity.ok(save);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Booking> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Booking booking = this.bookingService.read(id)
        return ResponseEntity.ok(booking);
    }

    @PostMapping("update")
    public Booking update(@RequestBody Booking booking){
        return bookingService.update(booking);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void> delete(@PathVariable String id){
        log.info("Delete request: {}", id);
        this.bookingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public Set<Booking> findAll(){return bookingService.findAll();}
}
