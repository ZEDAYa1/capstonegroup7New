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
import za.ac.cput.domain.User;
import za.ac.cput.factory.UserFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
public class UserServiceImplTest {
    private static final User user1 = UserFactory.createUser( "sibusiso123", "sibusiso@example.com", "password123");
    private static final User user2 = UserFactory.createUser( "soso456", "soso@example.com", "password456");
    private static final User user3 = UserFactory.createUser( "luyolo789", "luyolo@example.com", "password789");

    @Autowired
    private UserServiceImpl service; // Assuming UserServiceImpl is your UserService implementation

    @Test
    void a_save() {
        System.out.println("Created: ");
        User created1 = service.save(user1);
        assertNotNull(created1);
        System.out.println(created1);

        User created2 = service.save(user2);
        assertNotNull(created2);
        System.out.println(created2);

        User created3 = service.save(user3);
        assertNotNull(created3);
        System.out.println(created3);
    }

    @Test
    void b_read() {
        User read = service.read(user1.getUserId()); // Assuming getUserId() is the method to get the userId
        assertEquals(read.getUserId(), user1.getUserId());
        System.out.println("Show user: " + read);
    }

    @Test
    void c_update() {
    }

    @Test
    void f_delete() {
        boolean success = service.delete(user3.getUserId());
        assertTrue(success);
        System.out.println("Delete user: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all users: ");
        System.out.println(service.findAll());
    }
}
