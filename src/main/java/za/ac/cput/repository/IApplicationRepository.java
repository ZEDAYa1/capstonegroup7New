package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Application;

/* IApplicationRepository.java
 *  This is a interface for Application entity.
 *  Zachariah Matsimella 220097429
 */
@Repository
public interface IApplicationRepository extends JpaRepository<Application, String> {
}
