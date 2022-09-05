package springboot.petclinic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.petclinic.model.Doctor;
import springboot.petclinic.model.Owner;
import springboot.petclinic.repository.DoctorRepository;
import springboot.petclinic.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	
	@PostMapping("/addDoctor")
	
	public ResponseEntity<Doctor> addOwner(@Valid @RequestBody Doctor doctor) {
		
		return new ResponseEntity<Doctor>(doctorService.addOwner(doctor), HttpStatus.CREATED);
	}
	
		@PutMapping("updateDoctorwithPet/{doctorId}/Pet/{petId}")
		public ResponseEntity<Doctor> updateDoctorToPet(@PathVariable Long doctorId , @PathVariable Long petId ){
			return new ResponseEntity<Doctor>(doctorService.updateDoctorToPet(doctorId,petId), HttpStatus.OK);
		}

		
	}
	

