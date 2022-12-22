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
	   
	   private DataSource dataFactory;	
	   
	   public MemberDAO() {
		    try {
		       Context ctx = new InitialContext();
		       dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
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
			String sql = "SELECT * FROM tbl_member";	
			
			ResultSet rs = null;
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					String mid = rs.getString("mid");
					String name = rs.getString("name");
										
					MemberDTO dto = new MemberDTO(mid, null, name, null);
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
			
			String sql = "INSERT INTO tbl_member (mid, mpw, name, birth) VALUES (?, ?, ?, ?)";
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getMid());
				pstmt.setString(2, dto.getMpw());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getBirth());
				
				pstmt.executeUpdate();				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
		}

		public MemberDTO read(String mid) {
			MemberDTO dto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT mid, name, To_CHAR(birth, 'yyyy-mm-dd') birth "
					+ "FROM tbl_member WHERE mid = ?";
			
			ResultSet rs = null;
			
			try {
				conn = dataFactory.getConnection();
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mid);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String name = rs.getString("name");
					String birth = rs.getString("birth");									
					
					dto = new MemberDTO(mid, null, name, birth);
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
			String sql = "UPDATE tbl_member SET name = ?, birth = ? WHERE mid = ? AND mpw = ?";
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getBirth());
				pstmt.setString(3, dto.getMid());
				pstmt.setString(4, dto.getMpw());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
		}

		public int delete(String mid, String mpw) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM tbl_member WHERE mid = ? AND mpw = ?";
			int result = 0;
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mid);
				pstmt.setString(2, mpw);
				
				result = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
			return result;
		}

		public MemberDTO login(String mid, String mpw) {
			MemberDTO login = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "SELECT name FROM tbl_member WHERE mid = ? AND mpw = ?";
			ResultSet rs = null;
			
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mid);
				pstmt.setString(2, mpw);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					String name = rs.getString(1);
					login = new MemberDTO(mid, null, name, null);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll(null, pstmt, conn);
			}
			
			return login;
		}
		

}
