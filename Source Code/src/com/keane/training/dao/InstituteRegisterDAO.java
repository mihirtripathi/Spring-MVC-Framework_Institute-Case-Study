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
import com.keane.training.domain.Institute;

public class InstituteRegisterDAO {
	public int registerInstitute(final Institute institute) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, institute.getIname());
				pStmt.setString(2, institute.getIpassword());
				pStmt.setString(3, institute.getIaddress());
				pStmt.setInt(4, institute.getNseats());
				pStmt.setInt(5, institute.getNcourses());
				pStmt.setInt(6,institute.getNfaculty());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_INSTITUTE, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	public boolean validateInstitute(final String iname) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, iname);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SqlMapper.FETCH_INSTITUTE,
					paramMapper, SqlMapper.MAP_INSTITUTE);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}

}
