package com.infobip.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infobip.domain.Url;
import com.infobip.dto.CreateUrlDTO;
import com.infobip.dto.UrlCreatedResponse;
import com.infobip.service.UrlService;

@RestController
@RequestMapping("/url")
public class UrlController {
	
	@Autowired
	private UrlService urlService;

	@PostMapping("")
	public UrlCreatedResponse createUrl(@RequestBody (required = true) CreateUrlDTO url) {
		
		return urlService.createUrl(url);
	}
	
	@GetMapping("/shorturl/{source}")
	public ResponseEntity<Object> redirect(@PathVariable ("source") String source, HttpServletResponse httpServletResponse) throws URISyntaxException {
		
		Url url = urlService.getUrl(source);
		URI destination = new URI(url.getDestination());
		HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(destination);
	    if (url.getType() == 301) {
	    	 return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_PERMANENTLY);
		}
	    else {
	    	 return new ResponseEntity<>(httpHeaders, HttpStatus.MOVED_TEMPORARILY);
		}
	   
	
	}

	@GetMapping("/statistic/{accountId}")
	public Map<String, Integer> statistic(@PathVariable  ("accountId") String accountId) {
		
		return urlService.getStatistic(accountId);
		
	}
	
	
}
