package com.keane.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.keane.dbfw.ResultMapper;
import com.keane.training.domain.Student;
import com.keane.training.domain.Complain;
import com.keane.training.domain.Feedback;
import com.keane.training.domain.Institute;
import com.keane.training.domain.Msg;
import com.keane.training.domain.Req;
import com.keane.training.domain.Resp;


public class SqlMapper {

	public static final String FETCH_STUDENT = "select * from student where stud_id=?";

	public static final String FETCH_STUD = "select * from student";
		
	public static final String FETCH_INSTITUTE = "select * from institute where iname=?";
	
	public static final String FETCH_INS = "select * from institute";
	
	public static final String FETCH_FEEDBACK = "select * from feedback";
	
	public static final String FETCH_COMPLAIN = "select * from complain";
	
	public static final String FETCH_REQUEST = "select * from req";
	
	public static final String FETCH_RESP = "select * from resp";
	
	public static final String FETCH_MSG = "select * from msg";


	public static final String ADD_STUDENT = "insert into student values(?,?,?,?,?,?,?)";
	
	public static final String ADD_INSTITUTE = "insert into institute values(?,?,?,?,?,?)";
	
	public static final String ADD_FEEDBACK = "insert into feedback values(?,?,?)";
	
	public static final String ADD_COMPLAIN = "insert into complain values(?,?,?)";
	
	public static final String ADD_REQUEST = "insert into req values(?,?,?)";
	
	public static final String ADD_RESP = "insert into resp values(?,?,?)";
	
	public static final String ADD_MSG = "insert into msg values(?,?)";

	
	public static final String UPDATE_STUDENT = "update student set email=? where stud_id=?";

	
	public static final String DELETE_INSTITUTE = "delete from institute where iname=?";
    
	
	public static final ResultMapper MAP_STUDENT = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Student student = new Student();
			student.setSpassword(rs.getString("spassword"));
			student.setStud_id(rs.getInt("stud_id"));
			student.setSname(rs.getString("sname"));
			student.setSqualification(rs.getString("squalification"));
			student.setScontact(rs.getString("scontact"));
			student.setSaddress(rs.getString("saddress"));
			student.setEmail(rs.getString("email"));

			return student;
			
		}
	};
	
	public static final ResultMapper MAP_INSTITUTE = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Institute institute = new Institute();
			institute.setIpassword(rs.getString("ipassword"));
			institute.setIname(rs.getString("iname"));
			institute.setIaddress(rs.getString("iaddress"));
			institute.setIname(rs.getString("iname"));
			institute.setNseats(rs.getInt("nseats"));
			institute.setNcourses(rs.getInt("ncourses"));
			institute.setNfaculty(rs.getInt("nfaculty"));

			return institute;
			
		}
	};
	
	public static final ResultMapper MAP_FEEDBACK = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Feedback feedback = new Feedback();
			feedback.setIname(rs.getString("iname"));
			feedback.setFeedback(rs.getString("feedback"));
			feedback.setStud_id(rs.getInt("stud_id"));
			
			return feedback;
			
		}
	};
	
	public static final ResultMapper MAP_COMPLAIN = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Complain complain = new Complain();
			complain.setStud_id(rs.getInt("stud_id"));
			complain.setIname(rs.getString("iname"));
			complain.setComplain(rs.getString("complain"));
			
			return complain;
			
		}
	};
	
	public static final ResultMapper MAP_REQUEST = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Req req = new Req();
			req.setIname(rs.getString("iname"));
			req.setStud_id(rs.getInt("stud_id"));
			req.setReq(rs.getString("req"));
			
			return req;
			
		}
	};
	
	public static final ResultMapper MAP_RESP = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Resp resp = new Resp();
			resp.setStud_id(rs.getInt("stud_id"));
			resp.setIname(rs.getString("iname"));
			resp.setResp(rs.getString("resp"));
			
			return resp;
			
		}
	};
	
	public static final ResultMapper MAP_MSG = new ResultMapper() {

		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Msg msg = new Msg();
			msg.setIname(rs.getString("iname"));
			msg.setMsg(rs.getString("msg"));
			
			return msg;
			
		}
	};
}