package com.example.Enrollment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String birthdate;
    
    @Column(nullable = false)
    private long phoneNumber;

	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName= firstName;
	}

	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName= lastName;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email= email;
	}

	public void setBirthdate(String birthdate) {
		// TODO Auto-generated method stub
		this.birthdate= birthdate;
	}

	public void setphoneNumber(long phoneNumber) {
		// TODO Auto-generated method stub
		this.phoneNumber= phoneNumber;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public String getBirthdate() {
		// TODO Auto-generated method stub
		return birthdate;
	}

	public long getphoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
	}
	
   
	
}