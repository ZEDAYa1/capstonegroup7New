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
import za.ac.cput.domain.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class LoginServiceImplTest {
    private static final Login login1 = LoginFactory.createLogin("sibusiso", "password123");
    private static final Login login2 = LoginFactory.createLogin("soso", "password456");
    private static final Login login3 = LoginFactory.createLogin("luyolo", "password789");

    @Autowired
    private LoginServiceImpl service;

    @Test
    void a_save() {
        System.out.println("Created: ");
        Login created1 = service.save(login1);
        assertNotNull(created1);
        System.out.println(created1);

        Login created2 = service.save(login2);
        assertNotNull(created2);
        System.out.println(created2);

        Login created3 = service.save(login3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        Login read = service.read(login1.getUsername()); // Use the saved login object's username
        assertNotNull(read);
        assertEquals(read.getUsername(), login1.getUsername());
        System.out.println("Show login: " + read);
    }

    @Test
    void f_delete() {
        boolean success = service.delete(login3.getUsername());
        assertTrue(success);
        System.out.println("Delete login: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all logins: ");
        System.out.println(service.findAll());
    }
}
