/*
 * TenantService.java
 * This is the TenantService class
 * Author: Tshegofatso Molefe {219001235}
 * Date: 20 June 2023
 * */
package za.ac.cput.service;

import za.ac.cput.domain.Tenant;
import java.util.Set;

public interface TenantService extends IService<Tenant, String> {
    Set<Tenant> getAll();
}
