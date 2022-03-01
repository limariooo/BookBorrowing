package com.appllication.teluslibrary.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreateUserDto {
	public String firstName;

	public String lastName;

	public String email;
}
