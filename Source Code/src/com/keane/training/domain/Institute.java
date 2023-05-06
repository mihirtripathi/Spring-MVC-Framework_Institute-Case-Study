package com.keane.training.domain;

public class Institute {
	private String iname;
	private String ipassword;
	private String iaddress;
	private int nseats;
	private int ncourses;
	private int nfaculty;
	
	public Institute(String iname, String ipassword, String iaddress, int nseats, int ncourses, int nfaculty) {
		super();
		this.iname = iname;
		this.ipassword = ipassword;
		this.iaddress = iaddress;
		this.nseats = nseats;
		this.ncourses = ncourses;
		this.nfaculty = nfaculty;
	}
	public Institute(String iname, String ipassword) {
		super();
		this.iname = iname;
		this.ipassword = ipassword;
	}
	public Institute() {
		super();
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getIpassword() {
		return ipassword;
	}
	public void setIpassword(String ipassword) {
		this.ipassword = ipassword;
	}
	public String getIaddress() {
		return iaddress;
	}
	public void setIaddress(String iaddress) {
		this.iaddress = iaddress;
	}
	public int getNseats() {
		return nseats;
	}
	public void setNseats(int nseats) {
		this.nseats = nseats;
	}
	public int getNcourses() {
		return ncourses;
	}
	public void setNcourses(int ncourses) {
		this.ncourses = ncourses;
	}
	public int getNfaculty() {
		return nfaculty;
	}
	public void setNfaculty(int nfaculty) {
		this.nfaculty = nfaculty;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Institute [iname=");
		builder.append(iname);
		builder.append(", ipassword=");
		builder.append(ipassword);
		builder.append(", iaddress=");
		builder.append(iaddress);
		builder.append(", nseats=");
		builder.append(nseats);
		builder.append(", ncourses=");
		builder.append(ncourses);
		builder.append(", nfaculty=");
		builder.append(nfaculty);
		builder.append("]");
		return builder.toString();
	}

}
