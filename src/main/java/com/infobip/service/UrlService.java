package com.infobip.service;

import java.util.Map;

import com.infobip.domain.Url;
import com.infobip.dto.CreateUrlDTO;
import com.infobip.dto.UrlCreatedResponse;

public interface UrlService {
	
	public UrlCreatedResponse createUrl(CreateUrlDTO url);
	
	public Url getUrl(String url);

	public Map<String, Integer> getStatistic(String accountid);

}
