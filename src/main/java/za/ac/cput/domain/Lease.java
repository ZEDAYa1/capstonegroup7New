package za.ac.cput.domain;

import java.util.Date;

public class Lease {
    private String leaseId;
    private String lessor;
    private String lessee;
    private Date startDate;
    private Date endDate;

    public Lease(String leaseId, String lessor, String lessee, Date startDate, Date endDate) {
        this.leaseId = leaseId;
        this.lessor = lessor;
        this.lessee = lessee;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Lease(Builder builder) {
        this.leaseId = builder.leaseId;
        this.lessor = builder.lessor;
        this.lessee = builder.lessee;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public String getLeaseId() {
        return leaseId;
    }

    public String getLessor() {
        return lessor;
    }

    public String getLessee() {
        return lessee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setLeaseId(String leaseId) {
        this.leaseId = leaseId;
    }

    public void setLessor(String lessor) {
        this.lessor = lessor;
    }

    public void setLessee(String lessee) {
        this.lessee = lessee;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseId='" + leaseId + '\'' +
                ", lessor='" + lessor + '\'' +
                ", lessee='" + lessee + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public static class Builder{
        private String leaseId;
        private String lessor;
        private String lessee;
        private Date startDate;
        private Date endDate;

        public Builder setLeaseId(String leaseId){
            this.leaseId = leaseId;
            return this;
        }

        public Builder setLessor(String lessor){
            this.lessor = lessor;
            return this;
        }

        public Builder setLessee(String lessee){
            this.lessee = lessee;
            return this;
        }

        public Builder setStartDate(Date startDate){
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder copy(Lease lease){
            this.leaseId = lease.leaseId;
            this.lessor = lease.lessor;
            this.lessee = lease.lessee;
            this.startDate = lease.startDate;
            this.endDate = lease.endDate;
            return null;
        }

        public Lease build(){
            return new Lease(this);
        }
    }
}
