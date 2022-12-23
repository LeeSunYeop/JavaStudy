package kr.co.repository;

import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.command.Command;
import kr.co.domain.BoardDTO;
import kr.co.domain.SearchPageTO;

public class BoardDAO {
	
	private DataSource dataFactory;
	
	
	public BoardDAO() {
		   try {
			Context ctx = new InitialContext();
			   dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}
	
	public Map<String, Command> callMenu(){
		Map<String, Command> menus = new HashMap<String, Command>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_menu";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String uri = rs.getString("uri");
				String fullpkg = rs.getString("fullpkg");
				
				Class<?> menu = Class.forName(fullpkg);
				
				Constructor<?> cons = menu.getConstructor();
				Command t = (Command) cons.newInstance();
				
				menus.put(uri, t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return menus;
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void commitOrRollback(Connection conn, int result) {

		
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
	}

	public SearchPageTO<BoardDTO> list(int curPage, String criteria, String keyword) {
		SearchPageTO<BoardDTO> pt = new SearchPageTO<BoardDTO>(curPage, criteria, keyword);
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM "
				+ "(SELECT rownum rnum, num, bid, title, "
				+ "TO_CHAR(writeday, 'yyyy-mm-dd') writeday, readcnt, repIndent, name FROM "
				+ "(SELECT * FROM tbl_board "
				+ "WHERE "+criteria+" LIKE ? "
				+ "ORDER BY repRoot DESC, repStep ASC)) "
				+ "WHERE rnum BETWEEN ? AND ?";
		
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			
			int amount = getAmountForSearch(conn, criteria, keyword);
			pt.setAmount(amount);
			int starNum = pt.getStartNum();
			int endNum = pt.getEndNum();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, starNum);
			pstmt.setInt(3, endNum);
			
			
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String bid = rs.getString("bid");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				String name = rs.getString("name");
				
				list.add(new BoardDTO(num, bid, title, null, 0, writeday, readcnt, 0, 0, repIndent, name));
			}
			pt.setList(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
				
		
		return pt;
	}

	private int getAmountForSearch(Connection conn, String criteria, String keyword) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT COUNT(num) FROM tbl_board WHERE "+criteria+" LIKE ? ";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+keyword+"%");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				amount = rs.getInt(1);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		return amount;
	}

	public BoardDTO read(int num) {
		
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num= ?";
		ResultSet rs = null;
		
		int result1 = 0;
		int result2 = 0;
		int result = 0;
		
		try {
			conn = dataFactory.getConnection();
			
			conn.setAutoCommit(false);
			
			result1 = increaseReadcnt(conn, num);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String bid = rs.getString("bid");
				String title = rs.getString("title");
				String content = rs.getString("content");
				content = content.replace("\n", "<br>");
				String name = rs.getString("name");
				
				
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				
				dto = new BoardDTO(num, bid, title, content, -1, 
						writeday, readcnt, -1, -1, -1, name);

			}
			
			result2 = 1;
			
			result = result1 * result2;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			commitOrRollback(conn, result);
			
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	private int increaseReadcnt(Connection conn, int num) {
		int result1 = 0;
		
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET readcnt = readcnt +1 WHERE num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			result1 = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
		return result1;
	}

	public void insert(BoardDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board(num , bid,"
				+ "title, content, pw, repRoot,repStep, repIndent, name) "
				+ "VALUES (Seq_board_num.NEXTVAL,?,?,?,?,seq_board_num.CURRVAL,?,?,?)";
		
		try {
			conn = dataFactory.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, dto.getBid());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getPw());
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setString(7, dto.getName());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public SearchPageTO<BoardDTO> search(int curPage, String criteria, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(BoardDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET title=?, "
				+ "content=? WHERE num = ? AND pw = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
			pstmt.setInt(4, dto.getPw());
			
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
			
		}
		
		
		
		
	}

	public BoardDTO updateui(int num) {
		
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num= ?";
		ResultSet rs = null;

		
		try {
			conn = dataFactory.getConnection();
			

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String bid = rs.getString("bid");
				String title = rs.getString("title");
				String content = rs.getString("content");
	
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				String name = rs.getString("name");
				
				dto = new BoardDTO(num, bid, title, content, -1, 
						writeday, readcnt, -1, -1, -1, name);

			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	public void reply(int orgNum, BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO tbl_board (num, bid, title, content, pw, repRoot, "
				+ "repStep, repIndent, name) VALUES (seq_board_num.NEXTVAL, ?, ?, ? ,?,?,?,?, ?)";
		
		int result = 0;
		int result1 = 0;
		int result2 = 0;
		
		try {
			conn = dataFactory.getConnection();
			
			conn.setAutoCommit(false);
			
			BoardDTO orgDto = getOrgBoard(conn, orgNum);
			
			boolean isExists = isExistsAnotherReply(conn, orgDto);
			
			if (isExists) {
				result1 = increaseRepStep(conn, orgDto);
			}else {
				result1 = 1;
			}
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBid());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getPw());
			pstmt.setInt(5, orgDto.getRepRoot());
			pstmt.setInt(6, orgDto.getRepStep()+1);
			pstmt.setInt(7, orgDto.getRepIndent()+1);
			pstmt.setString(8, dto.getName());
			result2 = pstmt.executeUpdate();
			
			result = result1 * result2;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			commitOrRollback(conn, result);
			
			closeAll(null, pstmt, conn);
			
		}
		
	}

	private int increaseRepStep(Connection conn, BoardDTO orgDto) {
		int result1 = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_board SET repStep = repStep + 1 WHERE repRoot = ?"
				+ "AND repStep > ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orgDto.getRepRoot());
			pstmt.setInt(2, orgDto.getRepStep());
			
			result1 = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		return result1;
	}

	private boolean isExistsAnotherReply(Connection conn, BoardDTO orgDto) {
		boolean isExists = false;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT MAX(repStep) FROM tbl_board WHERE repRoot = ? AND repStep > ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orgDto.getRepRoot());
			pstmt.setInt(2, orgDto.getRepStep());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int maxRepStep = rs.getInt(1);
				if(maxRepStep > 0) {
					isExists = true;
				}else {
					isExists = false;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);
		}
		
		
		return isExists;
	}

	private BoardDTO getOrgBoard(Connection conn, int orgNum) {
		
		BoardDTO orgDto = null;
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_board WHERE num = ?";
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgNum);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				orgDto = new BoardDTO(orgNum, null, null, null, 0, null, 0, repRoot, repStep, repIndent, null);
				
			} else {

			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, null);
		}
		
		return orgDto;
	}

	public int delete(int num, int pw) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_board WHERE num =? AND pw = ?";
		
		int result = 0;
		
		try {
			conn = dataFactory.getConnection();
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
	



}
