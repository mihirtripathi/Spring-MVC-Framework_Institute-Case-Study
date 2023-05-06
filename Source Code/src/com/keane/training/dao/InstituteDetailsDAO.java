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
import com.keane.training.domain.Institute;

public class InstituteDetailsDAO {
       
	static Logger log=Logger.getLogger(InstituteDetailsDAO .class);
	
    public static List getInstitutes() throws DBFWException,  DBConnectionException
    {
        List institutes=null;
        ConnectionHolder ch=null;
        Connection con=null;
        try {
            ch=ConnectionHolder.getInstance();
            con=ch.getConnection();
            
            log.debug("fetchig");
            institutes=DBHelper.executeSelect(con,SqlMapper.FETCH_INS,SqlMapper.MAP_INSTITUTE);
                    
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
        
        
        return institutes;
        
    }
}