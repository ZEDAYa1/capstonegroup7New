/* PaymentRepository.java
 Repository class for Payment
 Author: Zachary Carstens (221054022)
 Date: 9 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.HashSet;
import java.util.Set;

public class PaymentRepository implements iPaymentRepository{

    private static PaymentRepository repository = null;
    private Set<Payment> PaymentDB = null;

    private PaymentRepository() {
        PaymentDB = new HashSet<Payment>();
    }

    public static PaymentRepository getRepository() {
        if (repository == null) {
            repository = new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        boolean success = PaymentDB.add(payment);
        if (!success)
            return null;
        return payment;
    }

    @Override
    public Payment read(String paymentId) {
        for (Payment p : PaymentDB)
            if (p.getPaymentId().equals(paymentId))
                return p;
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment oldPayment = read(payment.getPaymentId());
        if (oldPayment != null) {
            PaymentDB.remove(oldPayment);
            PaymentDB.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(String paymentId) {
        Payment paymentToDelete = read(paymentId);
        if (paymentToDelete == null)
            return false;
        PaymentDB.remove(paymentToDelete);
        return true;
    }

    public Set<Payment> getAll() {
        return PaymentDB;
    }

}
