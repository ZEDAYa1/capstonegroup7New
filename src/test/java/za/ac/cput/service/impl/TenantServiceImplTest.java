/*
 * AgentServiceImplTest.java
 * Author: Sibusiso Dwayi(220226466)
 * Date: 14 June 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class TenantServiceImplTest {
    private static Tenant tenant = TenantFactory.createTenant("William", "Herondale", "willandtess@gmail.com", "0762201549");
    private static Tenant tenant2 = TenantFactory.createTenant("James", "Bond", "Jamesbond@gmail.com", "0760254818");
    private static Tenant tenant3 = TenantFactory.createTenant("Radford", "Burger", "Radford@gmail.com", "084520052");

    @Autowired
    private TenantServiceImpl service;

    @Test
    void a_save() {
        Tenant created = service.save(tenant);
        assertEquals(tenant.getTenantId(), created.getTenantId());
        System.out.println("Created: " + created);

        Tenant created2 = service.save(tenant2);
        assertEquals(tenant2.getTenantId(), created2.getTenantId());
        System.out.println("Created: " + created2);

        Tenant created3 = service.save(tenant3);
        assertEquals(tenant3.getTenantId(), created3.getTenantId());
        System.out.println("Created: " + created3);
    }

    @Test
    void b_read() {
        Tenant read = service.read(tenant.getTenantId());
        assertEquals(read.getTenantId(), tenant.getTenantId());
        System.out.println("Show tenant: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(tenant3.getTenantId());
        assertTrue(success);
        System.out.println("Delete tenant: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all tenants: ");
        System.out.println(service.findAll());
    }
}
