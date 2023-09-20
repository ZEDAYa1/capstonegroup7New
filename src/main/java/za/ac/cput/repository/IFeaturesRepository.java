package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Features;

//sonwabiso Moni
//219275041

@Repository
public interface IFeaturesRepository extends JpaRepository<Features,String> {
 //public Set<Features> getAll();

}
