/* ComplaintRepository.java
 Entity for the Contact
 Author: Sibusiso Dwayi(220226466)
 Date: 7 April 2023
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Complaint;
import za.ac.cput.domain.Contact;

import java.util.HashSet;
import java.util.Set;

public class ComplaintRepository implements IComplaintRepository{
    private static ComplaintRepository respository = null;
    private Set<Complaint> complaintDB = null;

    private ComplaintRepository(){
        complaintDB = new HashSet<Complaint>();
    }

    public static ComplaintRepository getRespository(){
        if (respository ==null){
            respository = new ComplaintRepository();
        }
        return respository;
    }

    @Override
    public Complaint create(Complaint complaint) {
        boolean success = complaintDB.add(complaint);
        if (!success)
            return null;
        return complaint;
    }

    @Override
    public Complaint read(String complaintId) {
        for (Complaint c : complaintDB) {
            if (c.getComplaintId().equals(complaintId))
                return c;
        }
        return null;
    }

    @Override
    public Complaint update(Complaint complaint) {
        Complaint oldComplaint = read(complaint.getComplaintId());
        if (oldComplaint != null){
            complaintDB.remove(oldComplaint);
            complaintDB.add(complaint);
            return complaint;
        }
        return null;
    }

    @Override
    public boolean delete(String complaintId) {
        Complaint complaintToDelete = read(complaintId);
        if (complaintToDelete == null)
            return false;
        complaintDB.remove(complaintToDelete);
        return true;
    }
    @Override
    public Set<Complaint> getAll() {
        return complaintDB;
    }
}
