package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Student;

public class StudentUpdateDAO {
	
	public static int updateStudent(final String email,final int stud_id)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper UPDISCOUNT=new ParamMapper()
			{

				
				public void mapParams(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setDouble(2, stud_id);
					preStmt.setString(1, email);
					
					
					
				}

				
			};
			
		result=DBHelper.executeUpdate(con,SqlMapper.UPDATE_STUDENT,UPDISCOUNT);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	
}
