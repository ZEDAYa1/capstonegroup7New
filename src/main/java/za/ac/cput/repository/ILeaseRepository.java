package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Lease;

public interface ILeaseRepository extends JpaRepository<Lease, String> {

}
