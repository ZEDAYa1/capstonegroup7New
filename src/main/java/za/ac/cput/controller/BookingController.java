package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Booking;
import za.ac.cput.service.BookingService;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/booking/")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    BookingController(BookingService service){
        this.bookingService = service;
    }

    @PostMapping("/create")
    public Booking create(@RequestBody Booking booking){
        return bookingService.create(booking);
    }

    @GetMapping("/read/{id}")
    public Booking read(@PathVariable String id){
        return  bookingService.read(id);
    }

    @PostMapping("/update")
    public Booking update(@RequestBody Booking booking){
        return  bookingService.update(booking);
    }

    @DeleteMapping("/delete{id}")
    public  boolean delete(@PathVariable String id){
        return  bookingService.delete(id);
    }

    @GetMapping("/getall")
    public List<Booking> getAll(){
        return bookingService.getall();
    }
}
