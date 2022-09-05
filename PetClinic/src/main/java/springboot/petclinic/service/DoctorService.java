package springboot.petclinic.service;

import javax.validation.Valid;

import springboot.petclinic.model.Doctor;

public interface DoctorService {

	Doctor addOwner(@Valid Doctor doctor);

	

	Doctor updateDoctorToPet(Long doctorId, Long petId);

}
