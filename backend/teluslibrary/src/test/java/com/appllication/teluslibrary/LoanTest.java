package com.appllication.teluslibrary;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appllication.teluslibrary.controllers.LoanController;
import com.appllication.teluslibrary.entities.Loan;
import com.appllication.teluslibrary.payload.CreateLoanDto;
import com.appllication.teluslibrary.payload.LoanDto;
import com.appllication.teluslibrary.repositories.LoanRepository;
import com.appllication.teluslibrary.services.LoanService;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TeluslibraryApplication.class)
public class LoanTest {
	@Autowired
	private LoanRepository loanRepository;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private LoanController loanController;
	
	
	//Get Loan
	/* Error setUs
	@Test
	void getLoan() {
		
		Loan loan = new Loan();
		loan.setCorrelative(25L);
		
		LoanService loanServiceM = mock(LoanService.class);
		this.loanController.setUs(loanServiceM);
		Mockito.when(loanServiceM.getLoan(25L)).thenReturn(loanService.mapLoanToDto(loan));
		
		LoanDto tmp_loan = loanController.getLoan(25L).getBody();
		
		MatcherAssert.assertThat(tmp_loan.id, equalTo(25L));
		
		
	}*/
	//Create Loan
	/*
	@Test
	void createLoan() {
		LoanDto loan = new LoanDto();
		loan.setBookTitle(null);
		loan.setId(14L);
		loan.setStatus("ON TIME");

		
		CreateLoanDto tmp = new CreateLoanDto();
		tmp.bookId = 15L;
		tmp.userId = 16L;
		tmp.id = 14L;
		
		
		LoanService loanServiceMock = mock(LoanService.class);
		Mockito.when(loanServiceMock.createLoan(tmp)).thenReturn(loanService.mapLoanToDto(loan));
		
		LoanDto tmp_loan = loanController.createLoan(tmp).getBody();
		
		MatcherAssert.assertThat(tmp_loan.id, equalTo(14L));
	}
	
	*/
	//Getloan with service
	 /*
	@Test
	void getLoan_Service() {
		List<Loan> catalog = loanRepository.findAll();
		
		LoanRepository loanRepo = mock(LoanRepository.class);
		Mockito.when(loanRepo.findAll()).thenReturn(catalog);
		
		List<LoanDto> tmp_loan = loanService.getActiveLoans();
		
		MatcherAssert.assertThat(tmp_loan.size(), equalTo(catalog));
	}
	*/
}
