package com.infobip.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.infobip.domain.Account;
import com.infobip.repository.AccountRepository;
import com.infobip.service.AccountService;

@Component
public class AuthenticationService implements UserDetailsService {

    @Autowired
    AccountService accountService;
    
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Account account = accountService.findById(id);
        accountRepository.findAll();
        if (account == null){
            throw new UsernameNotFoundException(id + " was not found");
        }
        return new org.springframework.security.core.userdetails.User(
        		account.getAccountId(),
        		account.getPassword(),
        		getAuthority());
        
    }
    
    private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
	}

}