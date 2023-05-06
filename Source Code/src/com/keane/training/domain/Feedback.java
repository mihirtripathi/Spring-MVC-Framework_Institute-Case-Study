package com.keane.training.domain;

public class Feedback {
	private String iname;
	private String feedback;
	private int stud_id;
	public Feedback(String iname, String feedback, int stud_id) {
		super();
		this.iname = iname;
		this.feedback = feedback;
		this.stud_id = stud_id;
	}
	public Feedback() {
		super();
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	@Override
	public String toString() {
		return "Feedback [iname=" + iname + ", feedback=" + feedback + ", stud_id=" + stud_id + "]";
	}
}
