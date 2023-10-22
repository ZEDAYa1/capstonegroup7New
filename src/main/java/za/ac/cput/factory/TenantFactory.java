/*
 * TenantFactory.java
 * This is the TenantFactory class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 6 April 2023
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Tenant;
import za.ac.cput.util.Helper;

public class TenantFactory {
    public static Tenant createTenant(String firstName, String lastName, String email, String contactNumber) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty((email))
                || Helper.isNullOrEmpty(contactNumber)) {
            return null;
        }
        String tenantId = Helper.generateId();
        String leaseId = Helper.generateId();

        if (!Helper.isValidEmail(email)) {
           return null;
        }

        Tenant tenant = new Tenant.Builder().setTenantId(tenantId)
                .setLeaseId(leaseId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setContactNumber(contactNumber)
                .build();

        return tenant;
    }
}
