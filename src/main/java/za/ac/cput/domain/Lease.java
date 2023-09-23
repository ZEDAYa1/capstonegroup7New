package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Lease implements Serializable {
    @Id
    @Column(name = "lease_Id")
    private String leaseId;
    private String terms;
    private LocalDate startDate;
    private LocalDate endDate;

    protected Lease(){

    }

    public Lease(String leaseId, String terms, LocalDate startDate, LocalDate endDate) {
        this.leaseId = leaseId;
        this.terms = terms;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Lease(Builder builder) {
        this.leaseId = builder.leaseId;
        this.terms = builder.terms;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public String getLeaseId() {
        return leaseId;
    }

    public String getTerms() {
        return terms;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setLeaseId(String leaseId) {
        this.leaseId = leaseId;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseId='" + leaseId + '\'' +
                ", terms='" + terms + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class Builder{
        private String leaseId;
        private String terms;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder setLeaseId(String leaseId){
            this.leaseId = leaseId;
            return this;
        }

        public Builder setTerms(String terms){
            this.terms = terms;
            return this;
        }

        public Builder setStartDate(LocalDate startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder copy(Lease lease){
            this.leaseId = lease.leaseId;
            this.terms = lease.terms;
            this.startDate = lease.startDate;
            this.endDate = lease.endDate;
            return null;
        }

        public Lease build(){
            return new Lease(this);
        }
    }
}
