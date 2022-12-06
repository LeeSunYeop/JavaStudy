package kr.co.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.domain.GroupDTO;

public class GroupDAO {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "dw1";
	private static final String PASSWORD = "dw1";
	
	public GroupDAO() {
		try {
			Class.forName(GroupDAO.DRIVER);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
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

	public int insert(GroupDTO dto, int id, String ctyname, String hcname) {
		int result = -1;
		int result1 = -1;
		int result2 = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO tbl_group (id, gname) VALUES (?, ?)";
		
		try {
			conn = DriverManager.getConnection(
					GroupDAO.URL, GroupDAO.USERNAME, GroupDAO.PASSWORD);
			
			conn.setAutoCommit(false);
			
			result1 = insert_country(conn, id, ctyname, hcname);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getGname());
			
			result2 = pstmt.executeUpdate();
			
			result = result1 * result2;	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			commitOrRollback(result, conn);
			
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}
		
	private int insert_country(Connection conn, int id, String ctyname, String hcname) {
		int result1 = -1;
			
		PreparedStatement pstmt = null;
		String sql2 = "INSERT INTO tbl_country (id, ctyname, hcname) VALUES (?, ?, ?)";
			
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, id);
			pstmt.setString(2, ctyname);
			pstmt.setString(3, hcname);
			
			result1 = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			closeAll(null, pstmt, null);
		}
			
		return result1;
	}

	public List<GroupDTO> select() {
		List<GroupDTO> list = new ArrayList<GroupDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_country";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					GroupDAO.URL, GroupDAO.USERNAME, GroupDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int cid = rs.getInt("cid");
				
				String ctyname = rs.getString("ctyname");
				String hcname = rs.getString("hcname");
				String id = rs.getString("id");
				
				list.add(new GroupDTO(cid, ctyname, hcname, id)); //hcname?
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public GroupDTO selectById(int id) {
		GroupDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_country WHERE id = ?";		
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					GroupDAO.URL, GroupDAO.USERNAME, GroupDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String ctyname = rs.getString(2);
				String hcname = rs.getString(3);
				String gname = rs.getString(4);
				
				dto = new GroupDTO(id, ctyname, hcname, gname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public int update(GroupDTO dto, int id, String ctyname, String hcname) {
		int result = -1;
		int result1 = -1;
		int result2 = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE tbl_group SET gname = ? WHERE id = ?";		
		try {
			conn = DriverManager.getConnection(
					GroupDAO.URL, GroupDAO.USERNAME, GroupDAO.PASSWORD);
			
			conn.setAutoCommit(false);
			
			result1 = update_country(conn, id, ctyname, hcname);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getGname());
			pstmt.setInt(2, dto.getId());
			
			
			result2 = pstmt.executeUpdate();
			
			result = result1 * result2;
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			commitOrRollback(result, conn);
			
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}
		
	private int update_country(Connection conn, int id, String ctyname, String hcname) {
		int result1 = -1;
			
		PreparedStatement pstmt = null;
		String sql2 = "UPDATE tbl_country SET ctyname = ?, hcname = ? WHERE id = ?";
			
		try {
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setString(1, ctyname);
			pstmt.setString(2, hcname);
			pstmt.setInt(3, id);
			
			result1 = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			closeAll(null, pstmt, null);
		}
			
		return result1;
	}

	public int delete(GroupDTO groupDTO, int id) {
		int result = -1;
		int result1 = -1;
		int result2 = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM tbl_group WHERE id = ?";		
		try {
			conn = DriverManager.getConnection(
					GroupDAO.URL, GroupDAO.USERNAME, GroupDAO.PASSWORD);
			
			conn.setAutoCommit(false);
			
			result1 = update_country(conn, id, null, null);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);			
			
			result2 = pstmt.executeUpdate();
			
			result = pstmt.executeUpdate();		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			commitOrRollback(result, conn);
			
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}
		
	private int delete_country(Connection conn, int id) {
		int result1 = -1;
			
		PreparedStatement pstmt = null;
		String sql2 = "DELETE FROM tbl_country WHERE id = ?";
			
		try {
			pstmt = conn.prepareStatement(sql2);
			
			pstmt.setInt(1, id);
			
			result1 = pstmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			closeAll(null, pstmt, null);
		}
			
		return result1;
	}
			
	


}
