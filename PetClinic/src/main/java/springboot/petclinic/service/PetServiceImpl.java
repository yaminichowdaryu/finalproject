package springboot.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.petclinic.model.Owner;
import springboot.petclinic.model.Pet;
import springboot.petclinic.repository.OwnerRepository;
import springboot.petclinic.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService{

	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public Pet addPet(Pet pet) {
	
		return petRepository.save(pet);
	}

	@Override
	public List<Pet> getPet() {
		
		return petRepository.findAll();
	}

	@Override
	public Pet updatePet(Pet pet) {
		
		return petRepository.save(pet);
	}

	@Override
	public void deletePet(Long petId) {
		petRepository.deleteById(petId);
		
	}

	@Override
	public List<Pet> getPetByType(String type) {
		
		return petRepository.findByType(type);
	}

	@Override
	public List<Pet> getPetsByNameAndType(String petName, String type) {
	
		return petRepository.findBypetNameAndType(petName, type);
	}

	

	/*@Override
	public Pet updateOwnerToPet(Long petId, Long ownerId) {
		
		Pet pet = petRepository.findById(petId).get();
		Owner owner=ownerRepository.findById(ownerId).get();
		pet.addedPet(owner);
		return petRepository.save(pet);
	}
*/
	
	
	
}
