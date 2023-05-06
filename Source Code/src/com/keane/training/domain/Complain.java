package com.keane.training.domain;

public class Complain {

	private int stud_id;
	private String iname;
	private String complain;
	
	public Complain(String iname, String complain, int stud_id) {
		super();
		this.iname = iname;
		this.complain = complain;
		this.stud_id = stud_id;
	}
	public Complain() {
		super();
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getComplain() {
		return complain;
	}
	public void setComplain(String complain) {
		this.complain = complain;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	@Override
	public String toString() {
		return "Complain [iname=" + iname + ", complain=" + complain + ", stud_id=" + stud_id + "]";
	}

}
