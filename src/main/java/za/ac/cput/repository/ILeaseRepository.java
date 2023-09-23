package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Lease;

@Repository
public interface ILeaseRepository extends JpaRepository<Lease, String> {

}
