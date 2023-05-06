package com.keane.training.domain;

public class Student {
	
	private int stud_id;
	private String spassword;
	private String sname;
	private String squalification;
	private String scontact;
	private String saddress;
	private String email;
	
	public Student(int stud_id, String spassword) {
		super();
		this.stud_id = stud_id;
		this.spassword = spassword;
	}
	public Student(int stud_id, String spassword, String sname, String squalification, String scontact, String saddress,
			String email) {
		super();
		this.stud_id = stud_id;
		this.spassword = spassword;
		this.sname = sname;
		this.squalification = squalification;
		this.scontact = scontact;
		this.saddress = saddress;
		this.email = email;
	}
	public int getStud_id() {
		return stud_id;
	}
	public Student() {
		super();
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSqualification() {
		return squalification;
	}
	public void setSqualification(String squalification) {
		this.squalification = squalification;
	}
	public String getScontact() {
		return scontact;
	}
	public void setScontact(String scontact) {
		this.scontact = scontact;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [stud_id=");
		builder.append(stud_id);
		builder.append(", sname=");
		builder.append(sname);
		builder.append(", squalification=");
		builder.append(squalification);
		builder.append(", scontact=");
		builder.append(scontact);
		builder.append(", saddress=");
		builder.append(saddress);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}


}
