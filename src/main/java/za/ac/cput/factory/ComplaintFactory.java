/* ComplaintFactory.java
 Author: Sibusiso Dwayi(220226466)
 Date: 3 April 2023
*/
package za.ac.cput.factory;

import za.ac.cput.domain.Complaint;
import za.ac.cput.domain.Contact;
import za.ac.cput.util.Helper;

import java.sql.Date;

public class ComplaintFactory {
        public static Complaint createComplaint(String description,String date, String status){
            if (Helper.isNullOrEmpty(description) || Helper.isNullOrEmpty(status) || Helper.isNullOrEmpty(date)){
                return null;
            }
            String complaintId = Helper.generateId();

            return new Complaint.ComplaintBuilder().setComplaintId(complaintId)
                    .setDescription(description)
                    .setDate(date)
                    .setStatus(status)
                    .build();
        }
    }

