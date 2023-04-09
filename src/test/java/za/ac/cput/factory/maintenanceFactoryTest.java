package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Amenities;
import za.ac.cput.factory.maintenanceFactory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.maintenance;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class maintenanceFactoryTest {

    @Test
    public void test(){
        maintenance maintenance=maintenanceFactory.createmaintenance("CapeTown","SonwabisoMoni","10 dorset street","22115414");
        System.out.println(maintenance.toString());
        assertNotNull(maintenance);


    }
    @Test
    public void test_fail(){
        maintenance maintenance= maintenanceFactory.createmaintenance("george","soso","geggrt","225555");
        System.out.println(maintenance.toString());
        assertNotNull(maintenance);

    }
    @Test
    public void testEquality(){
     maintenance m1=maintenanceFactory.createmaintenance("george","sonwabiso","10 dorset","29878");
     maintenance m2=m1;
     assertEquals(m1, m2);

    }


    @Test
    public void testIdentity(){
        maintenance ma1=maintenanceFactory.createmaintenance("george","sonwabiso","10 dorset","29878");
        maintenance ma2=maintenanceFactory.createmaintenance("george","sonwabiso","10 dorset","29878");
        assertNotSame(ma1, ma2);

    }


    @Test
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    public void testTimeout(){
        System.out.println("Timeout passed");


    }


    @Test
    @Disabled
    public void testdisabled() {

        System.out.println("test disabled");
    }

}








