package springboot.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.petclinic.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{
	
	List<Pet> findByType(String type);
    
	List<Pet> findBypetNameAndType(String petName, String type);
}

