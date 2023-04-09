package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Amenities;
import za.ac.cput.factory.AmenitiesFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AmenitiesRepositoryTest {
private static AmenitiesRepository repository=AmenitiesRepository.getRepository();
private static Amenities amenities = AmenitiesFactory.createAmenities("resident","gym","public pool","cpe town","deliveryroom","inhouse");


    @Test
    void a_create() {
      Amenities created= repository.create(amenities);
      assertEquals(amenities.getPropertyID(),created.getPropertyID());
      System.out.println("created:  "+ created);

    }

    @Test
    void b_read() {
   Amenities read=repository.read(amenities.getPropertyID());
   assertNotNull(read);
   System.out.println("Read :"+ read);


    }

    @Test
    void c_update() {
     Amenities updated = new Amenities.Builder().copy(amenities).setLaundryFacilities("inhouse")
             .setNrOfSwimmingPools("publicAndResident")
             .setLocation("CapeTown")
             .setPackageRooms("delivery")
             .setAvailableParking("visitorsAndresident")
             .setWellnessFacilities("gym")
             .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated :"+updated);


    }

    @Test
    void e_delete() {
boolean success =repository.delete(amenities.getPropertyID());
assertTrue(success);
System.out.println("Deleted:" + success);





    }

    @Test
    void d_getAll() {
     System.out.println("Show all");
     System.out.println(repository.getAll());

    }
}