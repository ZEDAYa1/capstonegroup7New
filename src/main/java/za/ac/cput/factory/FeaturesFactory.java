package za.ac.cput.factory;
//sonwabiso Moni
//219275041
import za.ac.cput.domain.Features;
import za.ac.cput.util.Helper;
public class FeaturesFactory {

    public static Features buildFeatures(String pool,boolean kitchen,boolean garage,double size,int bathrooms,int bedrooms,boolean lounge,boolean laundry) {
        if(Helper.isNullOrEmpty(pool)
                ||Helper.isNullOrEmpty(String.valueOf(kitchen))
                ||Helper.isNullOrEmpty(String.valueOf(garage))
                ||Helper.isNullOrEmpty(String.valueOf(laundry))
                ||Helper.isNullOrEmpty(String.valueOf(lounge))
                ||Helper.isNullOrEmpty(String.valueOf(size))
                ||Helper.isNullOrEmpty(String.valueOf(bathrooms))
                ||Helper.isNullOrEmpty(String.valueOf(bedrooms)))
            return null;


        String propertyId = Helper.generateId();

        Features features =new Features.Builder().setPropertyId(propertyId)
                .setLounge(lounge)
                .setSize(size)
                .setPool(pool)
                .setKitchen(kitchen)
                .setBathrooms(bathrooms)
                .setPropertyId(propertyId)
                .setLaundry(laundry)
                .setBedrooms(bedrooms)
                .setGarage(garage)
                .build();

        return features;

    }

}









