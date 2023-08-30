package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DBUtil;

public class SignUpDAO {
	
	Connection conn = null;
	PreparedStatement stm = null;
	ResultSet rs = null;

	public void insertUser(String studentID, String userName, String password, String email) {
		String sql = "INSERT INTO dbUsers (StudentID, UserName, Password, Email, Level) VALUES (?, ?, ?, ?, '2')";
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentID);
			stm.setString(2, userName);
			stm.setString(3, password);
			stm.setString(4, email);
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void insertProfile(String studentID, String userName, String phoneNumber, String dateOfBirth, String sex,
	        String nation, String religion, String permanentAddress, String address, String unionDayJoining,
	        String dangDayJoiningRe, String dangDayJoining) {
	    String sql = "INSERT INTO uthdb.dbProfileUsers (StudentID, UserName, PhoneNumber, DateOfBirth, Sex, Nation, Religion, PermanentAddress, Address, UnionJoining, DangJoiningRE, DangJoining) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	    try {
	        conn = DBUtil.getConnection();
	        stm = conn.prepareStatement(sql);
	        stm.setString(1, studentID);
	        stm.setString(2, userName);
	        stm.setString(3, phoneNumber);
	        stm.setString(4, dateOfBirth);
	        stm.setString(5, sex);
	        stm.setString(6, nation);
	        stm.setString(7, religion);
	        stm.setString(8, permanentAddress);
	        stm.setString(9, address);
	        stm.setString(10, unionDayJoining);
	        stm.setString(11, dangDayJoiningRe);
	        stm.setString(12, dangDayJoining);

	        stm.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public void insertListSignUp(String studentID, String userName, String year, String department, String profileType, String title, String confirm, String theEditing, String confirmLevelDepartment) {
		String sql = "INSERT INTO uthdb.dbListSignUp (StudentID, UserName, Year, Department, ProfileType, Title, Confirm, TheEditing, ConfirmLevelDepartment)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentID);
			stm.setString(2, userName);
			stm.setString(3, year);
			stm.setString(4, department);
			stm.setString(5, profileType);
			stm.setString(6, title);
			stm.setString(7, confirm);
			stm.setString(8, theEditing);
			stm.setString(9, confirmLevelDepartment);
			
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void insertAssess(String studentID) {
		String sql = "INSERT INTO uthdb.dbAssess (StudentID, AssessTittle01, AssessTittle02, AssessTittle03, AssessTittle04, AssessTittle05)"
				+ "VALUES (?, 'Chưa đạt', 'Chưa đạt', 'Chưa đạt', 'Chưa đạt', 'Chưa đạt')";
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentID);
			
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void insertContentOfStudentID(String studentID) {
		String sql = "INSERT INTO uthdb.dbContentOfProofSV5T (StudentID) VALUES (?)";
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentID);
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void insertAttachmentsOfStudentID(String studentID) {
		String sql = "INSERT INTO uthdb.dbAttachmentsOfProofSV5T (StudentID) VALUES (?)";
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentID);
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}
	
	public void insertComment(String studentID) {
		String sql = "INSERT INTO uthdb.dbComment (StudentID) VALUES (?)";
		
		try {
			conn = DBUtil.getConnection();
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentID);
			stm.executeUpdate();
		} catch (Exception e) {
		}
	}
}
