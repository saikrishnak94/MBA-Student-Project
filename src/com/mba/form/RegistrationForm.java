package com.mba.form;

import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationForm {
	@NotEmpty(message="Fname should not be empty")
	String fName;
	@NotEmpty(message="Last name should not be empty")
	String lName;
	@NotEmpty(message="Student Id should not be empty")
	String sID;
	@NotEmpty(message="Student UEmail should not be empty")
	String uemail;
	@NotEmpty(message="Student PhoneNo should not be empty")
	String phoneNo;
	@NotEmpty(message="Student Email should not be empty")
	String perEmail;
	String verbal;
	String quantitative;
	String gpa;
    String entrydate;
    String concentrations[];
    String mailingAddr;
    
    
    
	public String getMailingAddr() {
		return mailingAddr;
	}

	public void setMailingAddr(String mailingAddr) {
		this.mailingAddr = mailingAddr;
	}

	public String[] getConcentrations() {
		return concentrations;
	}

	public void setConcentrations(String[] concentrations) {
		this.concentrations = concentrations;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public String getVerbal() {
		return verbal;
	}

	public void setVerbal(String verbal) {
		this.verbal = verbal;
	}

	public String getQuantitative() {
		return quantitative;
	}

	public void setQuantitative(String quantitative) {
		this.quantitative = quantitative;
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

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
