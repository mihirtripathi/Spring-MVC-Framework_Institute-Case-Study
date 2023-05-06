package com.keane.training.domain;

public class Msg {
	
	private String iname;
	private String msg;
	public Msg(String iname, String msg) {
		super();
		this.iname = iname;
		this.msg = msg;
	}
	public Msg() {
		super();
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Msg [iname=" + iname + ", msg=" + msg + "]";
	}

}
