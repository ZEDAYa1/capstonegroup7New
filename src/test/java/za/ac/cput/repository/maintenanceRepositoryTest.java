package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.domain.Client;
import za.ac.cput.repository.maintenanceRepository;
import za.ac.cput.domain.maintenance;
import za.ac.cput.factory.maintenanceFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class maintenanceRepositoryTest {

  private static maintenanceRepository repository= maintenanceRepository.getRepository();

  private static maintenance maintenance=maintenanceFactory.createmaintenance("George","Sonwabiso","10 dorset","21111");


    @Test
    void a_create() {
      maintenance created = repository.create(maintenance);
      assertNotNull(maintenance.getMaintenanceID(), created.getMaintenanceID());
      System.out.println("Created:"+created);



    }

    @Test
    void b_read() {
      maintenance read = repository.read(maintenance.getMaintenanceID());
      assertNotNull(read);
      System.out.println(read);

    }

    @Test
    void c_update() {
      maintenance updated = new maintenance.Builder().copy(maintenance).setAddress("10 dorset")
              .setHouseNr("29878")
              .build();
      assertNotNull(repository.update(updated));
      System.out.println("Updates :" + updated);


    }

    @Test
    void e_delete() {
      boolean success = repository.delete(maintenance.getMaintenanceID());
      assertTrue(success);
      System.out.println("Deleted :" + success);


    }

    @Test
    void getAll() {
      System.out.println("Show all");
      System.out.println(repository.getAll());

    }
}