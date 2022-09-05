package springboot.petclinic.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.petclinic.exception.ResourceNotFoundException;
import springboot.petclinic.model.Owner;
import springboot.petclinic.model.Pet;
import springboot.petclinic.repository.OwnerRepository;
import springboot.petclinic.repository.PetRepository;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	
	@Override
	public Owner addOwner(Owner owner) {
		return ownerRepository.save(owner);
	}



	@Override
	public List<Owner> getOwner() {
		
		return ownerRepository.findAll();
	}



	@Override
	public Owner updateOwner(Owner owner) {
	
		return ownerRepository.save(owner);
	}



	@Override
	public void deleteOwner(Long ownerId) {
		ownerRepository.deleteById(ownerId);
		
	}



	@Override
	public Owner getOwnerById(Long ownerId) {
		
	 Optional<Owner> owner = ownerRepository.findById(ownerId);
	 
	 if(owner.isPresent()) {
		 return owner.get();
	 }
	 throw new RuntimeException("Owner is not found for the Id="+ownerId);
	}



	@Override
	public Owner updateOwnerToPet(Long ownerId, Long petId) {
		Owner owner =ownerRepository.findById(ownerId).get();
		Pet pet = petRepository.findById(petId).get();
		if(owner != null && pet != null) {
			owner.ownerPet(pet);
			return ownerRepository.save(owner);
		}
		else {
			throw new ResourceNotFoundException("Owner", "ownerId", ownerId);
		}
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
