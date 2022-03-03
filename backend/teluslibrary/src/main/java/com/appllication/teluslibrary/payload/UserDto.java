package com.appllication.teluslibrary.payload;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public Integer activeLoans;
	public List<LoanDto> loans;
	
}
