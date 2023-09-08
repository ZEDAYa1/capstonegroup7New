package za.ac.cput.repository;
import za.ac.cput.domain.Amenities;
import java.util.Set;
public interface iAmenitiesRepository extends IRepository<Amenities,String> {
 public Set<Amenities> getAll();

}
