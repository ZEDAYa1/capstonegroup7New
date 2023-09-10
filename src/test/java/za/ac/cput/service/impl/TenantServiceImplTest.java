/*
 * TenantServiceImpl.java
 * This is the TenantServiceImpl test
 * Author: Tshegofatso Molefe {219001235}
 * Date: 5 September 2023
 * */

package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class TenantServiceImplTest {
    @Autowired
    private TenantServiceImpl service;

    private static Tenant tenant = TenantFactory.createTenant("William", "Herondale", "willandtess@email.com", "0762201549");

    @Test
    void a_create() {
        Tenant created = service.create(tenant);
        assertEquals(tenant.getTenantID(), created.getTenantID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Tenant read = service.read(tenant.getTenantID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Tenant newTenant = new Tenant.Builder().copy(tenant).setLastName("Wayland").build();
        Tenant updated = service.update(newTenant);
        assertEquals(newTenant.getLastName(), updated.getLastName());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Disabled
    void e_delete() {
        boolean deleted = service.delete(tenant.getTenantID());
        assertNotNull(deleted);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All");
        System.out.println(service.getAll());
    }
}
