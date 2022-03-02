package com.appllication.teluslibrary.payload;

import java.util.List;
import lombok.Data;

@Data
public class UserDto {
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public Integer activeLoans;
	private List<LoanDto> loans;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getActiveLoans() {
		return activeLoans;
	}
	public void setActiveLoans(Integer activeLoans) {
		this.activeLoans = activeLoans;
	}
	
	
}
