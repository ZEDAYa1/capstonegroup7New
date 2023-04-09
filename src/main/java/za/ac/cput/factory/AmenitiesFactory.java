package za.ac.cput.factory;

import za.ac.cput.domain.Amenities;
import za.ac.cput.util.Helper;
public class AmenitiesFactory {

    public static Amenities createAmenities(String availableParking, String wellnessFacilities,String nrOfSwimmingPools,String location,String packageRooms,String laundryFacilities){
        if (Helper.isNullOrEmpty(wellnessFacilities)||Helper.isNullOrEmpty(location))

            return null;


        String PropertyID = Helper.generateId();

        Amenities amenities=new Amenities.Builder().setNrOfSwimmingPools(nrOfSwimmingPools)
                .setPropertyID(PropertyID)
                .setLocation(location)
                .setPackageRooms(packageRooms)
                .setLaundryFacilities(laundryFacilities)
                .setWellnessFacilities(wellnessFacilities)
                .setAvailableParking(availableParking)
                .build();

        return amenities;

    }

}









