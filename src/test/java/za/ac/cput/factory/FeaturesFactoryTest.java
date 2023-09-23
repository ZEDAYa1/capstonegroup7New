package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.domain.Features;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class FeaturesFactoryTest {
    @Test
    public void test(){
Features features = new Features.Builder()
        .setGarage(true)
        .setBedrooms(5)
        .setLaundry(true)
        .setBathrooms(5)
        .setPool("outdoor pool")
        .setSize(5)
        .setLounge(true)
        .setKitchen(true)
        .build();
        System.out.println(features.toString());
        assertNotNull(features);

    }

    @Test
    public void test2() {
        Features features = FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);
        System.out.println(features);
        assertNotNull(features);


    }

    @Test
    public void testEquality(){
        Features am1 = FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);
        Features am2=am1;
        assertEquals(am1, am2);


    }



    @Test
    public void testIdentity(){
        Features ame1 = FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);
        Features ame2= FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);
        assertNotSame(ame1, ame2);



    }


    @Test
    public void test_fail(){

    Features features = FeaturesFactory.buildFeatures("outdoor",true,true,5,5,5,true,true);;
        System.out.println(features.toString());
        assertNotNull(features);


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