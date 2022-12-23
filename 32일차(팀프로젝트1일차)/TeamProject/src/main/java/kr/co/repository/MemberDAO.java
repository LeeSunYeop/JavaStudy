package kr.co.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.MemberDTO;

public class MemberDAO {
	
	   private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	   private static final String URL = "jdbc:oracle:thin:@192.168.0.33:1521:xe";
	   private static final String USERNAME = "dw1";
	   private static final String PASSWORD = "dw1";
	   
	   private DataSource dataFactory;	
	   
	   public MemberDAO() {
		    try {
		       Context ctx = new InitialContext();
		       dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		    } catch (NamingException e) {	       
		       e.printStackTrace();
		    }
		}
	   
	   private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
		}
		
		private void commitOrRollback(int result, Connection conn) {
			if (result > 0) {
				try {
					conn.commit();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
		}

		public List<MemberDTO> list() {
			List<MemberDTO> list = new ArrayList<MemberDTO>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM tbl_memberlogin";
			ResultSet rs = null;
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					int mid = rs.getInt("mid");
					String name = rs.getString("name");
										
					MemberDTO dto = new MemberDTO(mid, null, name, -1);
					list.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(rs, pstmt, conn);
			}
			
			return list;
		}

		public void insert(MemberDTO dto) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "INSERT INTO tbl_memberlogin (mid, password, name, age) VALUES (?, ?, ?, ?)";
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getMid());
				pstmt.setString(2, dto.getPassword());
				pstmt.setString(3, dto.getName());
				pstmt.setInt(4, dto.getAge());
				
				pstmt.executeUpdate();				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
		}

		public MemberDTO read(int mid) {
			MemberDTO dto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT * FROM tbl_memberlogin WHERE mid = ?";
			ResultSet rs = null;
			
			try {
				conn = dataFactory.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, mid);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					
					dto = new MemberDTO(mid, null, name, age);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(rs, pstmt, conn);
			}
			
			return dto;
		}

		public void update(MemberDTO dto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE tbl_memberlogin SET name = ?, age = ? WHERE mid = ? AND pw = ?";
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getName());
				pstmt.setInt(2, dto.getAge());
				pstmt.setInt(3, dto.getMid());
				pstmt.setString(4, dto.getPassword());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
		}

		public void delete(int mid, String password) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM tbl_memberlogin WHERE mid = ? AND password = ?";
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, mid);
				pstmt.setString(2, password);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
		}

		public MemberDTO login(int mid, String name) {
			MemberDTO login = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT mid, age FROM tbl_memberlogin WHERE mid = ? AND name = ?";
			ResultSet rs = null;
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, mid);
				pstmt.setString(2, name);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					int age = rs.getInt("age");
					login = new MemberDTO(mid, null, null, age);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
			return login;
		}
		

}
