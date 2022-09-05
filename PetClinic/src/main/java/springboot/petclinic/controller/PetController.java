package springboot.petclinic.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.petclinic.model.Pet;
import springboot.petclinic.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService petService;
	
	@PostMapping("/addPet")
	public ResponseEntity<Pet> addPet(@Valid @RequestBody Pet pet) {	
		return new ResponseEntity<Pet>(petService.addPet(pet), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllPets")
     public ResponseEntity<List<Pet>> getPet() {
		
		return new ResponseEntity<List<Pet>>(petService.getPet(),HttpStatus.OK);
	}
	
	@PutMapping("/updatePet/{petId}")
	public ResponseEntity<Pet> updatePet(@PathVariable Long petId, @RequestBody Pet pet) {
		pet.setPetId(petId);
		return new ResponseEntity<Pet>(petService.updatePet(pet),HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePet")
	public ResponseEntity<HttpStatus> deletePet(@RequestParam Long petId) {
		petService.deletePet(petId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	
			
		}
	
	@GetMapping("/Pet/filterByType")
	public ResponseEntity<List<Pet>> getPetByType(@RequestParam String type){
		return new ResponseEntity<List<Pet>>(petService.getPetByType(type),HttpStatus.FOUND);
	}
		
	
	@GetMapping("/Pet/filterByNameAndType")
		public ResponseEntity<List<Pet>> getPetsByNameAndType(@RequestParam String petName, String type){
		
		return new ResponseEntity<List<Pet>>(petService.getPetsByNameAndType(petName, type),HttpStatus.OK);
	}
	
	/*@PutMapping("/updateOwnerWithPet/{petId}/{ownerId}")
	public ResponseEntity<Pet> updateOwnerToPet(@PathVariable Long petId , @PathVariable Long ownerId ){
		return new ResponseEntity<Pet>(petService.updateOwnerToPet(petId,ownerId), HttpStatus.OK);
	}*/
	}


