package com.mba.form;

import org.hibernate.validator.constraints.NotEmpty;

public class Concetration {
	@NotEmpty(message="Degree code should not empty")
	String dCode;
	String DegreeCode;
	String stat;
	public String getDegreeCode() {
		return DegreeCode;
	}
	public void setDegreeCode(String degreeCode) {
		DegreeCode = degreeCode;
	}
	@NotEmpty(message="Concentration should not empty")
	String cName;
	@NotEmpty(message="Advisor should not empty")
	String advisor;
	public String getdCode() {
		return dCode;
	}
	public void setdCode(String dCode) {
		this.dCode = dCode;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getAdvisor() {
		return advisor;
	}
	public void setAdvisor(String advisor) {
		this.advisor = advisor;
	}
	public String getStat() {
		return stat;
	}
	public void setStat(String stat) {
		this.stat = stat;
	}
	
}
