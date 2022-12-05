package kr.co.dwitt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepDAO {
	
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "dw1";
	private static final String PASSWORD = "dw1";
	
	public DepDAO() {
		try {
			Class.forName(DepDAO.DRIVER);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int delete(int did) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_dep1 WHERE did = ?";
		
		try {
			conn = DriverManager.getConnection(
					DepDAO.URL, DepDAO.USERNAME, DepDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}
	
	public int delete2(int did) {
		int result = -1;
		int result1 = -1;
		int result2 = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_dep1 WHERE did = ?";
		String sql2 = "DELETE FROM tbl_emp WHERE did = ?";
		
		try {
			conn = DriverManager.getConnection(
					DepDAO.URL, DepDAO.USERNAME, DepDAO.PASSWORD);
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, did);
			
			result1 = pstmt.executeUpdate();
			
			pstmt.close();
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			
			result2 = pstmt.executeUpdate();
			
			result = result1 * result2;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result > 0) {
				try {
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}
	
	public int delete3(int did) {
		int result = -1;
		int result1 = -1;
		int result2 = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_dep1 WHERE did = ?";
		//String sql2 = "DELETE FROM tbl_emp WHERE did = ?";
		
		try {
			conn = DriverManager.getConnection(
					DepDAO.URL, DepDAO.USERNAME, DepDAO.PASSWORD);
			
			conn.setAutoCommit(false);
			
 			result1 = delte_emp(conn, did);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, did);
			
			result2 = pstmt.executeUpdate();
			
			result = result1 * result2;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (result > 0) {
				try {
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}

	private int delte_emp(Connection conn, int did) {
		int result1 = -1;
		
		PreparedStatement pstmt = null;
		String sql2 = "DELETE FROM tbl_emp WHERE did = ?";
		
		try {
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, did);
			
			result1 = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			closeAll(null, pstmt, null);
		}
		
		return result1;
	}

}
