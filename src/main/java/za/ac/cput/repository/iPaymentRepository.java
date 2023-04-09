/* IPaymentRepository.java
 Repository interface class for Payment
 Author: Zachary Carstens (221054022)
 Date: 9 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.Set;

public interface iPaymentRepository extends iRepository<Payment, String>{

    public Set<Payment> getAll();

}
