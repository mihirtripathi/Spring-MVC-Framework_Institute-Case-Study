package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Complain;

public class ComplainDAO {
	
	static Logger log=Logger.getLogger(ComplainDAO .class);
	
	public int registerComplain(final Complain complain) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, complain.getStud_id());
				pStmt.setString(2, complain.getIname());
				pStmt.setString(3, complain.getComplain());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_COMPLAIN, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	 public static List getComplain() throws DBFWException,  DBConnectionException
	    {
	        List complain=null;
	        ConnectionHolder ch=null;
	        Connection con=null;
	        try {
	            ch=ConnectionHolder.getInstance();
	            con=ch.getConnection();
	            
	            log.debug("fetchig");
	            complain=DBHelper.executeSelect(con,SqlMapper.FETCH_COMPLAIN,SqlMapper.MAP_COMPLAIN);
	                    
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
	        
	        
	        return complain;
	        
	    }

}