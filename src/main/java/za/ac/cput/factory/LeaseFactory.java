package za.ac.cput.factory;

import za.ac.cput.domain.Lease;
import za.ac.cput.util.Helper;

import java.util.Date;

public class LeaseFactory {
    public static Lease createLease(String lessor, String lessee, Date startDate, Date endDate){
        if(Helper.isNullOrEmpty(lessor)
        ||Helper.isNullOrEmpty(lessee)
        ||Helper.isDateNull(startDate)
        ||Helper.isDateNull(endDate)){
            return null;
        }


        String leaseId = Helper.generateId();

        Lease lease = new Lease.Builder().setLeaseId(leaseId)
                .setLessor(lessor)
                .setLessee(lessee)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();
        return lease;
    }
}
