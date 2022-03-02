package com.appllication.teluslibrary.payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class CreateLoanDto {
	public Long bookId;
	public Long userId;
	public Long id;
}
