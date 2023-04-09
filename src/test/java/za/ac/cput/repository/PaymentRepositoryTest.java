/* PaymentRepositoryTest.java
 Repository test class for Payment
 Author: Zachary Carstens (221054022)
 Date: 9 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentRepositoryTest {

    private static PaymentRepository repository = PaymentRepository.getRepository();
    private static Payment payment = PaymentFactory.createPayment(1500.00, 500.00, LocalDate.parse("2023-04-07"), "Credit Card", "Visa ending in 1234, expiring 12/25");

    @Test
    void a_create() {
        Payment created = repository.create(payment);
        assertEquals(payment.getPaymentId(), created.getPaymentId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Payment read = repository.read(payment.getPaymentId());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment).setPaymentTotalAmount(200.00)
                .setPaymentPaidAmount(750.00)
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(payment.getPaymentId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void e_getAll() {
        System.out.println("Show all:");
        System.out.println(repository.getAll());
    }
}