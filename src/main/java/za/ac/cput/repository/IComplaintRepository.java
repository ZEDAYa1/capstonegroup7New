/* IComplaintRepository.java
 Author: Sibusiso Dwayi(220226466)
 Date: 7 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Complaint;
import za.ac.cput.domain.Contact;

import java.util.Set;

public interface IComplaintRepository extends iRepository<Complaint, String>{
    public Set<Complaint> getAll();

}
