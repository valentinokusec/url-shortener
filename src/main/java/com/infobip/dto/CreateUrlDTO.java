package com.infobip.dto;

public class CreateUrlDTO {
	
	private String url;
	
	private Integer redirectType;
	
	public CreateUrlDTO() {
		super();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return redirectType;
	}

	public void setType(Integer type) {
		this.redirectType = type;
	}


	

}
