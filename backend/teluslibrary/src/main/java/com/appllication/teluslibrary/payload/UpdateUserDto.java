package com.appllication.teluslibrary.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UpdateUserDto {
	public Long id;
	public String firstName;
	public String lastName;
	public String email;
	public Integer activeLoans;
}
