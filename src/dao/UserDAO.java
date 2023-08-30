package dao;

import context.UserDTO;
import utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement stm = null;
	private ResultSet rs = null;

	private void closeConnection() throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public UserDTO checkLogin(String studentid, String password) throws SQLException, Exception {
		UserDTO result = null;
		try {
			conn = DBUtil.getConnection();
			if (conn != null) {

				String sql = "SELECT UserID, StudentID , UserName , Password , Email, Level"
						+ " FROM dbUsers WHERE StudentID = ? AND Password = ?";
				stm = conn.prepareStatement(sql);
				stm.setString(1, studentid);
				stm.setString(2, password);
				rs = stm.executeQuery();
				if (rs.next()) {
					result = new UserDTO(rs.getString("UserID"), rs.getString("StudentID"), rs.getString("UserName"), "***", rs.getString("Email"), rs.getString("Level"));
				}
			}
		} catch (Exception e) {
		} finally {
			closeConnection();
		}
		return result;
	}
}
