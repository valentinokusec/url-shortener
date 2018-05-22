package com.infobip.service;

import com.infobip.domain.Account;
import com.infobip.dto.AccountCreateResponseDTO;

public interface AccountService {
	
	public AccountCreateResponseDTO createAccount(String account);

	public Account findById(String id);

}
