/* Complaint.java
 Entity for the Complaint
 Author: Sibusiso Dwayi(220226466)
 Date: 31 March 2023
*/
package za.ac.cput.domain;

import java.sql.Date;

public class Complaint {
    private String complaintId;
    private String description;
    private String date;
    private String status;

    private Complaint() {

    }

    private Complaint(ComplaintBuilder builder) {
        this.complaintId = builder.complaintId;
        this.description = builder.description;
        this.date = builder.date;
        this.status = builder.status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId='" + complaintId + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    public static class ComplaintBuilder {
        private String complaintId;
        private String description;
        private String date;
        private String status;


        public ComplaintBuilder setComplaintId(String complaintId) {
            this.complaintId = complaintId;
            return this;
        }

        public ComplaintBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ComplaintBuilder setDate(String date) {
            this.date = date;
            return this;
        }

        public ComplaintBuilder setStatus(String status) {
            this.status = status;
            return this;
        }
        public ComplaintBuilder copy(Complaint complaint) {
            this.complaintId =complaint.complaintId;
            this.description = complaint.description;
            this.date = complaint.date;
            this.status = complaint.status;
            return this;
        }
        public Complaint build() {
            return new Complaint(this);
        }
    }
}
