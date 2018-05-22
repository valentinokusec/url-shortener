package com.infobip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infobip.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Account findById(String id);
	
	List<Account> findAll();

	Account findByAccountId(String accountId);

}
