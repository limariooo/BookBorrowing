package com.appllication.teluslibrary.payload;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDto {
	public Long id;
	public String bookTitle;
	public LocalDate startDate;
	public String status;
	public Float penalty;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Float getPenalty() {
		return penalty;
	}
	public void setPenalty(Float penalty) {
		this.penalty = penalty;
	}
	public LoanDto(Long id, String bookTitle, LocalDate startDate, String status, Float penalty) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.startDate = startDate;
		this.status = status;
		this.penalty = penalty;
	}
	public LoanDto() {
		super();
	}
	
	
}
