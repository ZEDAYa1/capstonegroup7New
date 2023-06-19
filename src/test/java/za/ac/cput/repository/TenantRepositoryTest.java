/*
 * TenantRepositoryTest.java
 * This is the test for the tenant repository
 * Author: Tshegofatso Molefe {219001235}
 * Date: 8 April 2023
 * */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Tenant;
import za.ac.cput.factory.TenantFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class TenantRepositoryTest {
    private static TenantRepository repository = TenantRepository.getRepository();
    private static Tenant tenant = TenantFactory.createTenant("Tshego", "Molefe", "tshego@email.com", "0213568978");
    @Test
    void a_create() {
        Tenant created = repository.create(tenant);
        assertNotNull(tenant.getTenantID(), created.getTenantID());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Tenant read = repository.read(tenant.getTenantID());
        assertNotNull(read);
        System.out.println(read);

    }

    @Test
    void c_update() {
        Tenant updated = new Tenant.Builder().copy(tenant).setEmail("Name@email.com")
                .setContactNumber("0812345678")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updates :" + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(tenant.getTenantID());
        assertTrue(success);
        System.out.println("Deleted :" + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all clients");
        System.out.println(repository.getAll());
    }

}