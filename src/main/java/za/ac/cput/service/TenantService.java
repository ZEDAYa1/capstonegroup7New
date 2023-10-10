/*
 * AgentService.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service;

import za.ac.cput.domain.Tenant;

import java.util.Set;

public interface TenantService extends IService <Tenant, String>{
    Set<Tenant> getAll();
}
