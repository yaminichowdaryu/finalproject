package springboot.petclinic.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@SequenceGenerator(name="doctorSeq" , initialValue=1111)
@Table
public class Doctor {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctorSeq")
	private Long doctorId;
	private String doctorName;
	private String gender;
	private String speacialist;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="visit" ,
	  joinColumns=   @JoinColumn(name="doctor_id"),  inverseJoinColumns =  @JoinColumn(name="pet_id"))

			
	
 private Set<Pet> visitedPet = new HashSet<>();
	
	

	public Doctor() {
		super();
	}



	public Long getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getSpeacialist() {
		return speacialist;
	}



	public void setSpeacialist(String speacialist) {
		this.speacialist = speacialist;
	}



	public Set<Pet> getVisitedPet() {
		return visitedPet;
	}



	public void setVisitedPet(Set<Pet> visitedPet) {
		this.visitedPet = visitedPet;
	}

	public void visitedPet(Pet pet) {
		visitedPet.add(pet);
	}


	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", gender=" + gender + ", speacialist="
				+ speacialist + ", visitedPet=" + visitedPet + "]";
	}





	
}
