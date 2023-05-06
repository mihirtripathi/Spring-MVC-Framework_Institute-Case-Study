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
import com.keane.training.domain.Feedback;

public class FeedbackDAO {
	
	static Logger log=Logger.getLogger(FeedbackDAO .class);
	
	public int registerFeedback(final Feedback feedback) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, feedback.getIname());
				pStmt.setString(2, feedback.getFeedback());
				pStmt.setInt(3, feedback.getStud_id());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_FEEDBACK, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	
	 public static List getFeedback() throws DBFWException,  DBConnectionException
	    {
	        List feedback=null;
	        ConnectionHolder ch=null;
	        Connection con=null;
	        try {
	            ch=ConnectionHolder.getInstance();
	            con=ch.getConnection();
	            
	            log.debug("fetchig");
	            feedback=DBHelper.executeSelect(con,SqlMapper.FETCH_FEEDBACK,SqlMapper.MAP_FEEDBACK);
	                    
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
	        
	        
	        return feedback;
	        
	    }

}