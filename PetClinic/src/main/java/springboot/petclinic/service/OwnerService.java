package springboot.petclinic.service;


import java.util.List;

import springboot.petclinic.model.Owner;


public interface OwnerService {

	Owner addOwner(Owner owner);
	
	List<Owner> getOwner();
	
	Owner updateOwner( Owner owner);
	
	void deleteOwner (Long ownerId);
	
	Owner getOwnerById(Long ownerId);

	Owner updateOwnerToPet(Long ownerId, Long petId);

	
}
