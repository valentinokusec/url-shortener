package com.infobip.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.infobip.domain.Account;
import com.infobip.domain.Statistic;
import com.infobip.domain.Url;
import com.infobip.dto.CreateUrlDTO;
import com.infobip.dto.UrlCreatedResponse;
import com.infobip.repository.AccountRepository;
import com.infobip.repository.StatisticRepository;
import com.infobip.repository.UrlRepository;
import com.infobip.web.exception.WrongTypeException;

@Service("urlService")
public class UrlServiceImpl implements UrlService{
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	private StatisticRepository statisticRepository;
	
	@Autowired
	private AccountRepository accountService;

	@Override
	public UrlCreatedResponse createUrl(CreateUrlDTO destination) {
		// TODO Auto-generated method stub
		
		Account account = accountService.findByAccountId(SecurityContextHolder.getContext().getAuthentication().getName());
		String source = RandomStringUtils.randomAlphabetic(10);
		
		if(destination.getType()==null)
		{
			destination.setType(302);
		}
		if(destination.getType()!= 302 && destination.getType() != 301) throw new WrongTypeException();
		
		Url url = new Url(source, destination.getUrl(), destination.getType());
		Statistic stats = new Statistic();
		stats.setCount(0);
		statisticRepository.save(stats);
		url.setStatistc(stats);
		urlRepository.save(url);
		
		Set<Url> urlList = account.getUrl();
		urlList.add(url);
		account.setUrl(urlList);
		accountService.save(account);
		
 		return new UrlCreatedResponse("localhost:8080/url/shorturl/" + source);
	}

	@Override
	public Map<String, Integer> getStatistic(String accountid) {
		// TODO Auto-generated method stub
		Account account = accountService.findByAccountId(accountid);
		
		Map<String, Integer> stats = new HashMap<>();
		for(Url url : account.getUrl())
		{
			
			stats.put(url.getDestination(), url.getStatistc().getCount());
		}
		
		return stats;
	}

	@Override
	public Url getUrl(String source) {
		// TODO Auto-generated method stub
		
		Url url = urlRepository.findBySource(source);
		Statistic stats = url.getStatistc();
		stats.setCount(stats.getCount()+1);
		statisticRepository.save(stats);
		urlRepository.findAll();
		
		return url;
	}

}
