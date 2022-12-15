package kr.co.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.domain.BoardDTO;

public class BoardDAO {
	// 4개 상수
	// 디폴트생성자는 생략
	// closeAll()
	// commitOrRollback()
	
	public static final String DIRVER = "oracle.jdbc.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USERNAME = "dw1";
	public static final String PASSWORD = "dw1";
	
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

	public List<BoardDTO> list() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board ORDER BY num DESC";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				BoardDTO dto = new BoardDTO(num, author, title, writeday, 
										readcnt, repRoot, repStep, repIndent);
				list.add(dto);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public void insert(BoardDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		String sql = "INSERT INTO tbl_board "
				+ "(num, author, pw, title, content, repRoot, repStep, repIndent) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getAuthor());
			pstmt.setInt(3, dto.getPw());
			pstmt.setString(4, dto.getTitle());
			pstmt.setString(5, dto.getContent());
			pstmt.setInt(6, dto.getNum());
			pstmt.setInt(7, 0);
			pstmt.setInt(8, 0);
			
			// 원래글의 repRoot: num
			// 답글의 repRoot: 원래글의 repRoot
			
			// 원래글의 repStep: 0
			// 답글의 repStep: 복잡함
			
			// 원래글의 repIndent: 0
			// 답글의 repIndent:
			// 1차 답글: 원래글의 repIndent + 1
			// 2차 답글: 1차 답글의 repIndent + 1
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

}
