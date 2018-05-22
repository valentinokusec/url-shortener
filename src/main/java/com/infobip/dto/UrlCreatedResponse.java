package com.infobip.dto;

public class UrlCreatedResponse {
	
	private String shortUrl;
	
	public UrlCreatedResponse() {
		super();
	}

	
	
	public UrlCreatedResponse(String url) {
		super();
		this.shortUrl = url;
	}



	public String getUrl() {
		return shortUrl;
	}

	public void setUrl(String url) {
		this.shortUrl = url;
	}

}
