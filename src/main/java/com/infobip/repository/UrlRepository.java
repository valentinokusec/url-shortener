package com.infobip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infobip.domain.Url;

public interface UrlRepository extends JpaRepository<Url, Long>{
	
	public Url findBySource(String source);

}
