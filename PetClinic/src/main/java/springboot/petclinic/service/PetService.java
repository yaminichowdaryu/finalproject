package springboot.petclinic.service;

import java.util.List;

import springboot.petclinic.model.Pet;

public interface PetService {

	Pet addPet(Pet pet);
	
	List<Pet> getPet();
	
	Pet updatePet(Pet pet);
	
	void deletePet(Long petId);
	
	List<Pet> getPetByType(String type);
	
	List<Pet> getPetsByNameAndType(String petName, String type);

	
}
