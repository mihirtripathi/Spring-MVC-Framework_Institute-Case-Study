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
import com.keane.training.domain.Msg;

public class MsgDAO {
	
	static Logger log=Logger.getLogger(MsgDAO .class);
	
	public int registerMsg(final Msg msg) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, msg.getIname());
				pStmt.setString(2, msg.getMsg());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_MSG, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	 public static List getMsg() throws DBFWException,  DBConnectionException
	    {
	        List msg=null;
	        ConnectionHolder ch=null;
	        Connection con=null;
	        try {
	            ch=ConnectionHolder.getInstance();
	            con=ch.getConnection();
	            
	            log.debug("fetchig");
	            msg=DBHelper.executeSelect(con,SqlMapper.FETCH_MSG,SqlMapper.MAP_MSG);
	                    
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
	        
	        
	        return msg;
	        
	    }

}