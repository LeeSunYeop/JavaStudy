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
		String sql = "SELECT num, author, title, To_CHAR(writeday, 'yyyy-mm-dd') writeday, "
				+ "readcnt, repRoot, repStep, repIndent "
				+ "FROM tbl_board ORDER BY repRoot DESC, repStep ASC";
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
				+ "(seq_board_num.NEXTVAL, ?, ?, ?, ?, seq_board_num.CURRVAL, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getAuthor());
			pstmt.setInt(2, dto.getPw());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			
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

	public BoardDTO read(int num) {
		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			
			conn.setAutoCommit(false); // 수동으로 바꾸기
			
			result1 = increaseReadcnt(conn, num);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				content = content.replace("\n", "<br>");
				// 글내용을 입력하면 줄바꿈이 적용되도록하는 코드임.
				
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");			
				
				dto = new BoardDTO(num, author, title, content, -1, writeday, readcnt, -1, -1, -1);
			}
			
			result2 = 1;
			
			result = result1 * result2;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			commitOrRollback(result, conn);
			
			closeAll(rs, pstmt, conn);
		}		
		
		return dto;
	}

	private int increaseReadcnt(Connection conn, int num) {
		int result1 = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET readcnt = readcnt + 1 WHERE num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result1 = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);  // conn을 닫아버리면 안되서 null로 해야한다.			
		}
		
		return result1;
	}

	public BoardDTO updateui(int num) {
		BoardDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;		
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);		
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String author = rs.getString("author");
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");			
				
				dto = new BoardDTO(num, author, title, content, -1, writeday, readcnt, -1, -1, -1);
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {		
			closeAll(rs, pstmt, conn);
		}		
		
		return dto;
	}

	public void update(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET author = ?, title = ?, content = ? "
				+ "WHERE num = ? AND pw = ?";
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getAuthor());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getNum());
			pstmt.setInt(5, dto.getPw());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public int delete(int num, int pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_board WHERE num = ? AND pw = ?";
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setInt(2, pw);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
		return result;
	}
	
	public void reply(int orgNum, BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board (num, author, title, content, pw, repRoot, repStep, repIndent) "
				+ "VALUES (seq_board_num.NEXTVAL, ?, ?, ?, ?, ?, ?, ?";
		
		try {
			conn = DriverManager.getConnection(
					BoardDAO.URL, BoardDAO.USERNAME, BoardDAO.PASSWORD);
			
			BoardDTO orgDto = getOrgBoard(conn, orgNum);
			
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getAuthor());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getPw());
			
			pstmt.setInt(5, orgDto.getRepRoot());
			pstmt.setInt(6, orgDto.getRepStep()+1);
			pstmt.setInt(7, orgDto.getRepIndent()+1);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}

	private BoardDTO getOrgBoard(Connection conn, int orgNum) {
		BoardDTO orgDto = null;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					URL, USERNAME, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgNum);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				orgDto = new BoardDTO(orgNum, null, null, null, -1, repRoot, repStep, repIndent);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return orgDto;
	}

}
