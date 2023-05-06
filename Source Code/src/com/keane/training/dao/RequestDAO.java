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
import com.keane.training.domain.Req;

public class RequestDAO {
	
	static Logger log=Logger.getLogger(RequestDAO .class);
	
	public int registerReq(final Req req) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, req.getIname());
				pStmt.setString(3, req.getReq());
				pStmt.setInt(2, req.getStud_id());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_REQUEST, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	 public static List getReq() throws DBFWException,  DBConnectionException
	    {
	        List req=null;
	        ConnectionHolder ch=null;
	        Connection con=null;
	        try {
	            ch=ConnectionHolder.getInstance();
	            con=ch.getConnection();
	            
	            log.debug("fetchig");
	            req=DBHelper.executeSelect(con,SqlMapper.FETCH_REQUEST,SqlMapper.MAP_REQUEST);
	                    
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
	        
	        
	        return req;
	        
	    }

}