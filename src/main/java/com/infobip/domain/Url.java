package com.infobip.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Url {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String source;
	
	@NotNull
	private String destination;
	
	@NotNull
	private int type;
	
	@ManyToOne
	private Account acccount;
	
	@OneToOne
	private Statistic statistc;
	
	public Url() {
		super();
	}

	

	public Url(@NotNull String source, @NotNull String destination, @NotNull int type) {
		super();
		this.source = source;
		this.destination = destination;
		this.type = type;
	}



	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Account getAcccount() {
		return acccount;
	}

	public void setAcccount(Account acccount) {
		this.acccount = acccount;
	}

	public Statistic getStatistc() {
		return statistc;
	}

	public void setStatistc(Statistic statistc) {
		this.statistc = statistc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
