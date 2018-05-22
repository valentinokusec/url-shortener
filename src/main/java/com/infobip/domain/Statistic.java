package com.infobip.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
public class Statistic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;;
	
	@NotNull
	private Integer count;
	
	@OneToOne
	private Url url;

	

	public Statistic() {
		super();
	}



	public Statistic(@NotNull Integer count) {
		super();
		this.count = count;
	}



	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Url getUrl() {
		return url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	
	
}
