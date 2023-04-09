package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Amenities;
import za.ac.cput.factory.AmenitiesFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class AmenitiesFactoryTest {
    @Test
    public void test(){
Amenities amenities= new Amenities.Builder()
        .setLocation("delft")
        .setAvailableParking("resident")
        .setNrOfSwimmingPools("visitors")
        .setPackageRooms("delivery")
        .setWellnessFacilities("gym")
        .setLaundryFacilities("inhouse")
        .build();
        System.out.println(amenities.toString());
        assertNotNull(amenities);

    }

    @Test
    public void test2() {
        Amenities amenities = AmenitiesFactory.createAmenities("residentAndvisitor", "gymAndSpa", "severl", "Capetown", "severalDeliveryRooms", "LaundryRoomsOrinHouseLaundry");
        System.out.println(amenities);
        assertNotNull(amenities);


    }

    @Test
    public void testEquality(){
        Amenities am1 = AmenitiesFactory.createAmenities("residentAndvisitor", "gymAndSpa", "severl", "Capetown", "severalDeliveryRooms", "LaundryRoomsOrinHouseLaundry");
        Amenities am2=am1;
        assertEquals(am1, am2);


    }



    @Test
    public void testIdentity(){
        Amenities ame1 = AmenitiesFactory.createAmenities("residentAndvisitor", "gymAndSpa", "severl", "Capetown", "severalDeliveryRooms", "LaundryRoomsOrinHouseLaundry");
        Amenities ame2=AmenitiesFactory.createAmenities("residentAndvisitor", "gymAndSpa", "severl", "Capetown", "severalDeliveryRooms", "LaundryRoomsOrinHouseLaundry");
        assertNotSame(ame1, ame2);



    }


    @Test
    public void test_fail(){

    Amenities amenities=AmenitiesFactory.createAmenities("","gym","","george","delivery","inhouse");
        System.out.println(amenities.toString());
        assertNotNull(amenities);


    }
   @Test
   @Timeout(value = 150,unit = TimeUnit.MILLISECONDS)
   public void testTimeout(){
   System.out.println("Timeout passed");


   }


    @Test
    @Disabled
     public void testdisabled() {

        System.out.println("test disabled");
    }

}