/* Payment.java
 POJO class for Payment
 Author: Zachary Carstens (221054022)
 Date: 7 April 2023
*/
package za.ac.cput.domain;

import java.time.LocalDate;

public class Payment {

    private String paymentId;

    private double paymentTotalAmount;

    private double paymentPaidAmount;

    private LocalDate paymentDate;

    private String paymentType;

    private String paymentDetails;

    private Payment() {
    }

    public Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentTotalAmount = builder.paymentTotalAmount;
        this.paymentPaidAmount = builder.paymentPaidAmount;
        this.paymentDate = builder.paymentDate;
        this.paymentType = builder.paymentType;
        this.paymentDetails = builder.paymentDetails;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getPaymentTotalAmount() {
        return paymentTotalAmount;
    }

    public double getPaymentPaidAmount() {
        return paymentPaidAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", paymentTotalAmount=" + paymentTotalAmount +
                ", paymentPaidAmount=" + paymentPaidAmount +
                ", paymentDate=" + paymentDate +
                ", paymentType='" + paymentType + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                '}';
    }

    public static class Builder {
        private String paymentId;

        private double paymentTotalAmount;

        private double paymentPaidAmount;

        private LocalDate paymentDate;

        private String paymentType;

        private String paymentDetails;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPaymentTotalAmount(double paymentTotalAmount) {
            this.paymentTotalAmount = paymentTotalAmount;
            return this;
        }

        public Builder setPaymentPaidAmount(double paymentPaidAmount) {
            this.paymentPaidAmount = paymentPaidAmount;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public Builder setPaymentDetails(String paymentDetails) {
            this.paymentDetails = paymentDetails;
            return this;
        }

        public Payment.Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.paymentTotalAmount = payment.paymentTotalAmount;
            this.paymentPaidAmount = payment.paymentPaidAmount;
            this.paymentDate = payment.paymentDate;
            this.paymentType = payment.paymentType;
            this.paymentDetails = payment.paymentDetails;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }

    }

}
