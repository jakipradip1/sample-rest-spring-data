package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerVO {
	private Long id;
	private String fName;
	private String lName;
	private String snn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getSnn() {
		return snn;
	}

	public void setSnn(String snn) {
		this.snn = snn;
	}

}
