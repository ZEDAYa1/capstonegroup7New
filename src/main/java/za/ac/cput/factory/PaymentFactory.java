/* PaymentFactory.java
 Factory class for Payment
 Author: Zachary Carstens (221054022)
 Date: 8 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Payment;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

public class PaymentFactory {

    public static Payment createPayment(double paymentTotalAmount, double paymentPaidAmount, LocalDate paymentDate, String paymentType, String paymentDetails) {

        String paymentId = Helper.generateId();

        if (Helper.isNullOrEmpty(String.valueOf(paymentTotalAmount)) || Helper.isNullOrEmpty(String.valueOf(paymentPaidAmount)) || Helper.isNullOrEmpty(String.valueOf(paymentDate)) || Helper.isNullOrEmpty(paymentType) || Helper.isNullOrEmpty(paymentDetails))
            return null;

        return new Payment.Builder().setPaymentId(paymentId)
                .setPaymentTotalAmount(paymentTotalAmount)
                .setPaymentPaidAmount(paymentPaidAmount)
                .setPaymentDate(paymentDate)
                .setPaymentType(paymentType)
                .setPaymentDetails(paymentDetails)
                .build();

    }

}
