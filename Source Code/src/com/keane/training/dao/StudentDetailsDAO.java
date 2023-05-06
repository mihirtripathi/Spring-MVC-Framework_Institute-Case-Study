package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Student;

public class StudentDetailsDAO {
       
	static Logger log=Logger.getLogger(StudentDetailsDAO .class);



    public static List getStudents() throws DBFWException,  DBConnectionException
    {
        List students=null;
        ConnectionHolder ch=null;
        Connection con=null;
        try {
            ch=ConnectionHolder.getInstance();
            con=ch.getConnection();
            
            log.debug("fetchig");
            students=DBHelper.executeSelect(con,SqlMapper.FETCH_STUD,SqlMapper.MAP_STUDENT);
                    
        } catch (DBConnectionException e) {
            throw new DBConnectionException("Unable to connect to db"+e);
        
        }
        finally {

            try {
            	if (con != null)
                    con.close();

            } catch (SQLException e) {
            }
        }
        
        
        return students;
        
    }
}