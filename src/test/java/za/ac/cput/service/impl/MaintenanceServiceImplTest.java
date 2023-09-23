package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Maintenance;
import za.ac.cput.factory.MaintenanceFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class MaintenanceServiceImplTest {

    private static Maintenance maintenance= MaintenanceFactory.createMaintenance("mould", LocalDate.parse("2022-02-19"));
    private static Maintenance maintenance2= MaintenanceFactory.createMaintenance("mould", LocalDate.parse("2023-02-08"));
    private static Maintenance maintenance3= MaintenanceFactory.createMaintenance("mould", LocalDate.parse("2023-02-08"));


    @Autowired
    private MaintenanceServiceImpl service;

    @Test
    void a_save() {
        Maintenance created = service.save(maintenance);
        assertEquals(maintenance.getRequestId(), created.getRequestId());
        System.out.println("Created: "+ created);

        Maintenance created2 = service.save(maintenance2);
        assertEquals(maintenance2.getRequestId(), created2.getRequestId());
        System.out.println("Created: "+ created2);

        Maintenance created3 = service.save(maintenance3);
        assertEquals(maintenance3.getRequestId(), created3.getRequestId());
        System.out.println("Created: "+ created3);
    }
    @Test
    void b_read() {
        Maintenance read = service.read(maintenance.getRequestId());
        assertEquals(read.getRequestId(), maintenance.getRequestId());
        System.out.println("Show maintanance: " + read);
    }

    @Test
    void delete() {
        boolean success = service.delete(maintenance3.getRequestId());
        assertNotNull(!success);
        System.out.println("Deleted :" + success);

    }

    @Test
    void getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}