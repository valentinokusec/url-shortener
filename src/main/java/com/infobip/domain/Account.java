package com.infobip.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Account {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String accountId;
	
	@NotNull
	private String password;
	
	@OneToMany
	private Set<Url> url;

	public Account() {
		super();
	}

	public Account(@NotNull String id, @NotNull String password) {
		super();
		this.accountId = id;
		this.password = password;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Url> getUrl() {
		return url;
	}

	public void setUrl(Set<Url> url) {
		this.url = url;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	


	
}
