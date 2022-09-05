package springboot.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.petclinic.model.Doctor;

@Repository
public interface DoctorRepository  extends JpaRepository<Doctor, Long>{

}
