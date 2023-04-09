/* IContactRepository.java
 Author: Sibusiso Dwayi(220226466)
 Date: 7 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Contact;

import java.util.List;
import java.util.Set;

public interface IContactRepository extends iRepository<Contact, String> {

    public Set<Contact> getAll();

}
