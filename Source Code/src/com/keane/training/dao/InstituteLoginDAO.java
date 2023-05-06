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

public class InstituteLoginDAO {
	static Logger log = Logger.getLogger(InstituteLoginDAO.class);

	public List validateInstitute(final String iname) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, iname);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_INSTITUTE,
					paramMapper, SqlMapper.MAP_INSTITUTE);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}

}
