package com.infobip.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infobip.dto.AccontCreateDTO;
import com.infobip.dto.AccountCreateResponseDTO;
import com.infobip.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@PostMapping("")
	public ResponseEntity<AccountCreateResponseDTO> createAccount(@RequestBody (required = true) AccontCreateDTO user) {
		
		AccountCreateResponseDTO account = accountService.createAccount(user.getAccountId());
		if(account.isSuccess())
		{
			return  ResponseEntity.status(HttpStatus.CREATED).body(account);
		}
		else {
			return  ResponseEntity.status(HttpStatus.OK).body(account);
		}
		
	}

}
