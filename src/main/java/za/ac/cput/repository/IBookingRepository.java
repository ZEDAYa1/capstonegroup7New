package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Booking;

public interface IBookingRepository extends JpaRepository<Booking, String> {

}
