package com.infobip.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.infobip.domain.Account;
import com.infobip.dto.AccountCreateResponseDTO;
import com.infobip.repository.AccountRepository;

@Service("accountService")
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AccountCreateResponseDTO createAccount(String accountId) {
		
		AccountCreateResponseDTO response = new AccountCreateResponseDTO();
		if(accountRepository.findByAccountId(accountId)!=null)
		{
			response.setDescription("Account already exists!");
			response.setSuccess(false);
			return response;
		}
			
		
		String password = RandomStringUtils.randomAlphabetic(8);
		Account account = new Account(accountId, passwordEncoder.encode(password));
		accountRepository.save(account);
		
		response.setDescription("Account created!");
		response.setSuccess(true);
		response.setPassword(password);
		return response;
		
	}

	@Override
	public Account findById(String id) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountId(id);
	}

}
