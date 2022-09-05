package springboot.petclinic.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.petclinic.exception.ResourceNotFoundException;
import springboot.petclinic.model.Doctor;
import springboot.petclinic.model.Owner;
import springboot.petclinic.model.Pet;
import springboot.petclinic.repository.DoctorRepository;
import springboot.petclinic.repository.PetRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;
@Autowired
private PetRepository petRepository;
	@Override
	public Doctor addOwner(@Valid Doctor doctor) {
		
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctorToPet(Long doctorId, Long petId) {
			Doctor doctor =doctorRepository.findById(doctorId).get();
			Pet pet = petRepository.findById(petId).get();
			if(doctor != null && pet != null) {
				doctor.visitedPet(pet);
				return doctorRepository.save(doctor);
			}
			else {
				throw new ResourceNotFoundException("Doctor", "doctorId", doctorId);
			}
		}

	
	

}
