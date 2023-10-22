package za.ac.cput.factory;

import za.ac.cput.domain.Lease;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

/* LeaseFactory.java
 *  This is a factory class for Lease entity.
 *  Zachariah Matsimella 220097429
 */
public class LeaseFactory {
    public static Lease createLease(String terms, LocalDate startDate, LocalDate endDate){
        if(Helper.isNullOrEmpty(terms)
        ||Helper.isDateNull(startDate)
        ||Helper.isDateNull(endDate)){
            return null;
        }


        String leaseId = Helper.generateId();

        Lease lease = new Lease.Builder().setLeaseId(leaseId)
                .setTerms(terms)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .build();
        return lease;
    }
}
