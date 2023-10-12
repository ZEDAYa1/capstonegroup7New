package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

/* Application.java
 *  This is a domain class for Application entity.
 *  Zachariah Matsimella 220097429
 */
@Entity
public class Application implements Serializable {
    private boolean bankStatement;
    private boolean paySlip;
    private String status;
    private String adress;
    private String email;
    private String contactNumber;
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate applicationDate;
    private String propertyId;
    private String tenantId;
    @Id
    @Column(name = "applicationId")
    private String applicationId;
    private boolean copyOfId;
    private String references;

    public Application(boolean bankStatement, boolean paySlip, String status, String adress, String email,
                       String contactNumber, int id, String firstName, String lastName, LocalDate applicationDate,
                       String propertyId, String tenantId, String applicationId, boolean copyOfId, String references) {
        this.bankStatement = bankStatement;
        this.paySlip = paySlip;
        this.status = status;
        this.adress = adress;
        this.email = email;
        this.contactNumber = contactNumber;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.applicationDate = applicationDate;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.applicationId = applicationId;
        this.copyOfId = copyOfId;
        this.references = references;
    }

    public Application(Builder builder){
        this.bankStatement = builder.bankStatement;
        this.paySlip = builder.paySlip;
        this.status = builder.status;
        this.adress = builder.adress;
        this.email = builder.email;
        this.contactNumber = builder.contactNumber;
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.applicationDate = builder.applicationDate;
        this.propertyId = builder.propertyId;
        this.tenantId = builder.tenantId;
        this.applicationId = builder.applicationId;
        this.copyOfId = builder.copyOfId;
        this.references = builder.references;
    }

    protected Application() {

    }

    public boolean isBankStatement() {
        return bankStatement;
    }

    public void setBankStatement(boolean bankStatement) {
        this.bankStatement = bankStatement;
    }

    public boolean isPaySlip() {
        return paySlip;
    }

    public void setPaySlip(boolean paySlip) {
        this.paySlip = paySlip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public boolean isCopyOfId() {
        return copyOfId;
    }

    public void setCopyOfId(boolean copyOfId) {
        this.copyOfId = copyOfId;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "Application{" +
                "bankStatement=" + bankStatement +
                ", paySlip=" + paySlip +
                ", status='" + status + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", applicationDate=" + applicationDate +
                ", propertyId='" + propertyId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", copyOfId=" + copyOfId +
                ", references='" + references + '\'' +
                '}';
    }

    public static class Builder{
        private boolean bankStatement;
        private boolean paySlip;
        private String status;
        private String adress;
        private String email;
        private String contactNumber;
        private int id;
        private String firstName;
        private String lastName;
        private LocalDate applicationDate;
        private String propertyId;
        private String tenantId;
        private String applicationId;
        private boolean copyOfId;
        private String references;

        public Builder setBankStatement(boolean bankStatement){
            this.bankStatement = bankStatement;
            return this;
        }

        public Builder setPaySlip(boolean paySlip){
            this.paySlip = paySlip;
            return this;
        }

        public Builder setStatus(String status){
            this.status = status;
            return this;
        }

        public Builder setAdress(String adress){
            this.adress = adress;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Builder setContactNumber(String contactNumber){
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setId(int id){
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder setApplicationDate(LocalDate applicationDate){
            this.applicationDate = applicationDate;
            return this;
        }

        public Builder setPropertyId(String propertyId){
            this.propertyId = propertyId;
            return this;
        }

        public Builder setTenantId(String tenantId){
            this.tenantId = tenantId;
            return this;
        }

        public Builder setApplicationId(String applicationId){
            this.applicationId = applicationId;
            return this;
        }

        public Builder setCopyOfId(boolean copyOfId){
            this.copyOfId = copyOfId;
            return this;
        }

        public Builder setReferences(String references){
            this.references = references;
            return this;
        }

        public Lease.Builder copy(Application application) {
            this.bankStatement = application.bankStatement;
            this.paySlip = application.paySlip;
            this.status = application.status;
            this.adress = application.adress;
            this.email = application.email;
            this.contactNumber = application.contactNumber;
            this.id = application.id;
            this.firstName = application.firstName;
            this.lastName = application.lastName;
            this.applicationDate = application.applicationDate;
            this.propertyId = application.propertyId;
            this.tenantId = application.tenantId;
            this.applicationId = application.applicationId;
            this.copyOfId = application.copyOfId;
            this.references = application.references;
            return null;
        }

        public Application build(){
            return new Application(this);
        }
    }
}