package com.keane.training.domain;

public class Req {
	
	private String iname;
	private int stud_id;
	private String req;
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public Req(String iname, int stud_id, String req) {
		super();
		this.iname = iname;
		this.stud_id = stud_id;
		this.req = req;
	}
	public Req() {
		super();
	}
	@Override
	public String toString() {
		return "Req [iname=" + iname + ", stud_id=" + stud_id + ", req=" + req + "]";
	}

}
