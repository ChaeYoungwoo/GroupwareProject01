package com.pcwk.ehr.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDao {
	final Logger log = LogManager.getLogger(getClass());
	
	private DataSource dataSource;
	
	public UserDao() {
		
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	public int doSave(UserVO inVO) throws SQLException {
		int flag = 0;
		
		Connection conn = dataSource.getConnection();
		
		StringBuilder sb = new StringBuilder(200);
		
		sb.append("INSERT INTO EMPLOYEE(empid, ename, password, position, deptno, hiredate, birthday)VALUES(?,?,?,?,?,SYSDATE,SYSDATE)");

		log.debug("sql: \n" + sb.toString());
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		pstmt.setInt(1, inVO.getEmpId());
		pstmt.setString(2, inVO.getName());
		pstmt.setString(3, inVO.getPassword());
		pstmt.setString(4, inVO.getPosition());
		pstmt.setInt(5, inVO.getDeptNo());
		
		log.debug("param: " + inVO.toString());
		
		flag = pstmt.executeUpdate();
		
		log.debug("4.flag: " + flag);

		pstmt.close();
		conn.close();
		
		return flag;
	}
	
	public UserVO doSelectOne(UserVO inVO) throws SQLException {
		UserVO outVO = null;
		
		Connection conn = dataSource.getConnection();
		StringBuilder sb = new StringBuilder(200);
		
		sb.append("SELECT empid, ename, password, position, deptno, birthday, hiredate FROM EMPLOYEE WHERE empid=?\n");
		log.debug("sql: \n" + sb.toString());
		
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		pstmt.setInt(1, inVO.getEmpId());
		
		log.debug("param: " + inVO.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			outVO = new UserVO();
			
			outVO.setEmpId(rs.getInt("empid"));
			outVO.setName(rs.getString("ename"));
			outVO.setPassword(rs.getString("password"));
			outVO.setPosition(rs.getString("position"));
			outVO.setDeptNo(rs.getInt("deptno"));
			outVO.setBirthday(rs.getString("birthday"));
			outVO.setHiredate(rs.getString("hiredate"));
			
			log.debug("OutVO: + " + outVO.toString());
			
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return outVO;
		
	}
	
}

