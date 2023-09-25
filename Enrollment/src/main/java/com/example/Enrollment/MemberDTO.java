package com.example.Enrollment;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
public class MemberDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Column(nullable = true)
    @Email
    private String email;

    @Column(nullable = true)
    private String birthdate;
    
    @Column(nullable = true)
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

	public void setBirthdate(@NotNull String birthdate) {
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

	public @NotNull String getBirthdate() {
		// TODO Auto-generated method stub
		return birthdate;
	}

	public long getphoneNumber() {
		// TODO Auto-generated method stub
		return phoneNumber;
	}
	
   
}
