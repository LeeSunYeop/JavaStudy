package kr.co.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.domain.MemberDTO;

public class MemberDAO {
	
	//static 상수 4개 선언
	//closeAll()
	//commitOrRollback()
	//디폴트 생성자
	
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "dw1";
	private static final String PASSWORD = "dw1";
	
	public MemberDAO() {
		try {
			Class.forName(MemberDAO.DRIVER);
			System.out.println("드라이버 로딩 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
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

	public void insert(MemberDTO dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO tbl_member (id, name, age) VALUES (?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO.URL, MemberDAO.USERNAME, MemberDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public List<MemberDTO> list() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_member";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO.URL, MemberDAO.USERNAME, MemberDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				//int age = rs.getInt("age");  나이는 자세히보기 할때 나오게끔 할거..
				
				//MemberDTO dato = new MemberDTO(id, name, -1);
				//list.add(dto);
				list.add(new MemberDTO(id, name, -1));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return list;
	}

	public MemberDTO read(int id) {
		MemberDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_member WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO.URL, MemberDAO.USERNAME, MemberDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				dto = new MemberDTO(id, name, age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		
		return dto;
	}

	public MemberDTO login(int id, String name) {
		MemberDTO login = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id, age FROM tbl_member WHERE id = ? AND name = ?";
		// * 를 넣으면 안되고 비밀번호로 설정된 값만 빼고 넣어야한다.
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO.URL, MemberDAO.USERNAME, MemberDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				int age = rs.getInt("age");
				login = new MemberDTO(id, null, age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}		
		
		return login;
	}

	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_member SET name = ?, age = ?";
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO.URL, MemberDAO.USERNAME, MemberDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setInt(3, dto.getId());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

	public void delete(int id) {
		Connection conn =null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM tbl_member WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO.URL, MemberDAO.USERNAME, MemberDAO.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
		
	}

}
