package springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.petclinic.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
