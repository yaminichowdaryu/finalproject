package springboot.petclinic.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@SequenceGenerator(name="ownerSeq" , initialValue=111)
@Table
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ownerSeq")
	private Long petId;
	
	@NotBlank(message ="PetName should not be blank")
	private String petName;
	
	private LocalDate birthDate;
	
	@NotBlank(message ="Type of the pet should be entered")
	private String type;
	
	private LocalDate visitDate;
	
	@NotBlank(message ="Description should not be blank")
	private String description;
	
	/*@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="owner_Id", referencedColumnName="ownerId")
	private Owner owner;*/
	
	@JsonIgnore
	@ManyToMany(mappedBy = "visitedPet")
	private List<Doctor> doctor;
	
	
	
@ManyToOne (cascade = CascadeType.ALL)
@JoinColumn(name="owner_id",referencedColumnName = "ownerId")
private Owner owner;


	public Pet() {
		super();
	}
	

	public List<Doctor> getDoctor() {
		return doctor;
	}



	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}



	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(LocalDate visitDate) {
		this.visitDate = visitDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petName=" + petName + ", birthDate=" + birthDate + ", type=" + type
				+ ", visitDate=" + visitDate + ", description=" + description + ", doctor=" + doctor + ", owner="
				+ owner + "]";
	}


	/*public void addedPet(Owner owner2) {
		this.owner = owner2;
		
	}*/
	
	
	
}
