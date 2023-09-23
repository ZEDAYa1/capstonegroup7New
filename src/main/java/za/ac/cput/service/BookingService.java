package za.ac.cput.service;

import za.ac.cput.domain.Booking;
import java.util.Set;

public interface BookingService extends IService <Booking, String> {
    public Set<Booking> getAll();
}
