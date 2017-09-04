package com.cubic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubic.service.QueryConstant;

@Entity
@Table(name = "CUSTOMER_NEW")
@NamedQueries({ @NamedQuery(name = QueryConstant.FIND_ALL, query = "Select c from CustomerEntity c"),
		@NamedQuery(name = QueryConstant.FIND_BY_NAME, query = "Select c from CustomerEntity c Where Upper(c.fName) like Upper(:fName)") })
public class CustomerEntity {
	@Id
	@SequenceGenerator(name = "cusSeq", sequenceName = "CUSTOMER_SQE_1", allocationSize = 1)
	@GeneratedValue(generator = "cusSeq")
	@Column(name = "ID")
	private Long id;
	@Column(name = "FIRST_NAME")
	private String fName;
	@Column(name = "LAST_NAME")
	private String lName;
	@Column(name = "SSN")
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

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", fName=" + fName + ", lName=" + lName + ", snn=" + snn + "]";
	}

}
