package za.ac.cput.repository;

import za.ac.cput.domain.Booking;

import java.util.Set;

public interface iBookingRepository extends IRepository<Booking, String>{
    public Set<Booking> getall();

    Set<Booking> getAll();
}
