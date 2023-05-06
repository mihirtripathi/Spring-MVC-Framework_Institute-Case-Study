package com.keane.training.domain;

public class Resp {

	private String iname;
	private int stud_id;
	private String resp;
	public Resp(String iname, int stud_id, String resp) {
		super();
		this.iname = iname;
		this.stud_id = stud_id;
		this.resp = resp;
	}
	public Resp() {
		super();
	}
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
	public String getResp() {
		return resp;
	}
	public void setResp(String resp) {
		this.resp = resp;
	}
	@Override
	public String toString() {
		return "Resp [iname=" + iname + ", stud_id=" + stud_id + ", resp=" + resp + "]";
	}
	
}
