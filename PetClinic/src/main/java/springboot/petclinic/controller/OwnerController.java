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


import springboot.petclinic.model.Owner;

import springboot.petclinic.service.OwnerService;

@RestController
public class OwnerController {

	
	@Autowired
	private OwnerService ownerService;
	
	
	@PostMapping("/addOwner")
	public ResponseEntity<Owner> addOwner(@Valid @RequestBody Owner owner) {
		
		return new ResponseEntity<Owner>(ownerService.addOwner(owner), HttpStatus.CREATED);
	
		
		
	}
	
	@GetMapping("/getOwner")
       public ResponseEntity<List<Owner>> getOwner() {
		
		return new ResponseEntity<List<Owner>>(ownerService.getOwner(), HttpStatus.OK);
	}
	
	@GetMapping("/getOwnerById/{ownerId}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable  Long ownerId ) {
		return new ResponseEntity<Owner>(ownerService.getOwnerById(ownerId), HttpStatus.FOUND);
	}

	@PutMapping("/updateOwner/{ownerId}")
	public ResponseEntity<Owner> updateOwner (@PathVariable Long ownerId, @RequestBody Owner owner) {
		owner.setOwnerId(ownerId);
		return new ResponseEntity<Owner>(ownerService.updateOwner(owner), HttpStatus.OK);
	}

	@DeleteMapping("/deleteOwner")
	public  ResponseEntity<HttpStatus> deleteOwner(@RequestParam Long ownerId) {
		 ownerService.deleteOwner(ownerId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	                                    
	@PutMapping("/updateOwnerWithPet/{ownerId}/Pet/{petId}")
	public ResponseEntity<Owner> updateOwnerToPet(@PathVariable Long ownerId , @PathVariable Long petId ){
		return new ResponseEntity<Owner>(ownerService.updateOwnerToPet(ownerId,petId), HttpStatus.OK);
	}

}
