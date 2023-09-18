/* ILandlordRepository.java
 Repository interface class for Landlord
 Author: Zachary Carstens (221054022)
 Date: 9 April 2023
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Landlord;
import java.util.Set;

public interface ILandlordRepository extends JpaRepository<Landlord, String> {

    public Set<Landlord> getAll();

}
