/* PaymentFactoryTest.java
 Factory test class for Payment
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payment;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    public void test() {
        Payment payment = PaymentFactory.createPayment(1500.00, 500.00, LocalDate.parse("2023-04-07"), "Credit Card", "Visa ending in 1234, expiring 12/25");
        System.out.println(payment.toString());
        assertNotNull(payment);
    }

}