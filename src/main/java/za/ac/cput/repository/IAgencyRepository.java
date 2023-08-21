/* IAgencyRepository.java
 Repository interface class for Agency
 Author: Zachary Carstens (221054022)
 Date: 17 June 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Agency;
import java.util.Set;

public interface IAgencyRepository extends IRepository<Agency, String>{

    public Set<Agency> getAll();

}
