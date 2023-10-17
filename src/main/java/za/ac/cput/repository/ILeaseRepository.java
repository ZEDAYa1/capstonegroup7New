package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Lease;

/* ILeaseRepository.java
 *  This is a interface class for Lease entity.
 *  Zachariah Matsimella 220097429
 */
@Repository
public interface ILeaseRepository extends JpaRepository<Lease, String> {

}
