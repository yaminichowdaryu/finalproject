package springboot.petclinic.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;






@Entity
@Table
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerId;
	
	@NotBlank(message ="OwnerName should not be 'blank'")
	private String ownerName;
	
	@NotBlank(message ="Address field shouldnot be blank")
	private String address;
	
	@NotBlank(message ="City field shouldnot be blank")
	private String city;
	
	@Column(unique = true)
	@Length(min=10,max=10, message="Mobile number must be 10 digits")
	private String telephone;
	
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="owner_Id", referencedColumnName="ownerId")
	private Owner owner;*/
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="pet_id", referencedColumnName = "petId")
	
	@OneToMany(mappedBy ="owner")
	
	private Set<Pet> pet=new HashSet<>();


	public Set<Pet> getPet() {
		return pet;
	}


	public void setPet(Set<Pet> pet) {
		this.pet = pet;
	}



	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getOwnerId() {
		return ownerId;
	}



	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}





	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", address=" + address + ", city=" + city
				+ ", telephone=" + telephone + ", pet=" + pet + "]";
	}



	public void ownerPet(Pet pet2) {
		pet.add(pet2);
		
	}




	/*@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", address=" + address + ", city=" + city
				+ ", telephone=" + telephone + "]";
	}*/
	
	

}