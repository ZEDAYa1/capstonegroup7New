/*
 * TenantFactoryTest.java
 * This is the test for the client entity
 * Author: Tshegofatso Molefe {219001235}
 * Date: 8 April 2023
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tenant;

import static org.junit.jupiter.api.Assertions.*;

class TenantFactoryTest {
    @Test
    public void test(){
        Tenant tenant = new Tenant.Builder()
                .setFirstName("Firstname")
                .setLastName("Lastname")
                .setEmail("email1@email.com")
                .setContactNumber("0895623265")
                .build();
        System.out.println(tenant.toString());
        assertNotNull(tenant);
    }
    @Test
    public void test2(){
        Tenant tenant = TenantFactory.createTenant("firstName", "lastName", "email@address.com", "0213564856");
        System.out.println(tenant.toString());
        assertNotNull(tenant);
    }

    @Test
    public void failTest(){
    Tenant tenant = TenantFactory.createTenant("", "",
            "","");
    failTest();
    }
}