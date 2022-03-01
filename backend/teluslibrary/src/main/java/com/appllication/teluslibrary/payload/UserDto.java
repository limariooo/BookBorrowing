package com.appllication.teluslibrary.payload;

import java.util.List;
import lombok.Data;

@Data
public class UserDto {
	public Long id;
	
	public String firstName;
	
	public String lastName;
	
	private String email;
	
	private Integer activeLoans;
	
	public List<LoanDto> loans;
}
