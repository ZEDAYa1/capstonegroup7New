/*
 * TenantServiceImplTest.java
 * Author: Tshegofatso Molefe(219001235)
 * Date: 05 October 2023
 * */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//crud
//srud
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class TenantServiceImplTest {
    private static Tenant tenant1 = TenantFactory.createTenant("William", "Herondale", "willandtess@gmail.com", "0762201549");
    private static Tenant tenant2 = TenantFactory.createTenant("James", "Bond", "Jamesbond@gmail.com", "0760254818");
    private static Tenant tenant3 = TenantFactory.createTenant("Radford", "Burger", "Radford@gmail.com", "084520052");


    @Autowired
    private TenantServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Tenant created1 = service.save(tenant1);
        assertNotNull(created1);
        System.out.println(created1);

        System.out.println("Created: ");
        Tenant created2 = service.save(tenant2);
        assertNotNull(created2);
        System.out.println(created2);

        System.out.println("Created: ");
        Tenant created3 = service.save(tenant3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Tenant read = service.read(tenant1.getTenantId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Tenant newTenant = new Tenant.Builder().copy(tenant3).setLastName("Wayland").build();
        Tenant updated = service.update(newTenant);
        assertNotNull(tenant3);
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean deleted = service.delete(tenant2.getTenantId());
        assertNotNull(deleted);
        System.out.println("Deleted: " + true);
    }

    @Test
    void d_getAll() {
        System.out.println("Get All");
        System.out.println(service.findAll());    }
}
