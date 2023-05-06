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
import com.keane.training.domain.Resp;

public class RespDAO {
	
	static Logger log=Logger.getLogger(RespDAO .class);
	
	public int registerResp(final Resp resp) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(2, resp.getIname());
				pStmt.setString(3, resp.getResp());
				pStmt.setInt(1, resp.getStud_id());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_RESP, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	 public static List getResp() throws DBFWException,  DBConnectionException
	    {
	        List resp=null;
	        ConnectionHolder ch=null;
	        Connection con=null;
	        try {
	            ch=ConnectionHolder.getInstance();
	            con=ch.getConnection();
	            
	            log.debug("fetchig");
	            resp=DBHelper.executeSelect(con,SqlMapper.FETCH_RESP,SqlMapper.MAP_RESP);
	                    
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
	        
	        
	        return resp;
	        
	    }

}