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

public class StudentRegisterDAO {
	public int registerStudent(final Student student) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, student.getStud_id());
				pStmt.setString(2, student.getSname());
				pStmt.setString(3, student.getSqualification());
				pStmt.setString(4, student.getScontact());
				pStmt.setString(5, student.getSaddress());
				pStmt.setString(6, student.getEmail());
				pStmt.setString(7, student.getSpassword());

			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_STUDENT, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	public boolean validateStudent(final int stud_id) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, stud_id);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SqlMapper.FETCH_STUDENT,
					paramMapper, SqlMapper.MAP_STUDENT);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}

}
