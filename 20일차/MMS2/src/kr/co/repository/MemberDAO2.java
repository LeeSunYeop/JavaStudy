package kr.co.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.domain.MemberDTO;

public class MemberDAO2 {  // 테이블만큼 MemberDAO 만들어 주면 된다.
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; //@뒤에 도메인주소가 없으면 ip주소를 넣으면 된다
	private static final String USERNAME = "dw1";
	private static final String PASSWORD = "dw1";
			
	public MemberDAO2() { // 디폴트생성자
		try {
			Class.forName(MemberDAO2.DRIVER);
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

	
	public int insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;  // select 작업할때 필요함
		
		String sql = "INSERT INTO tbl_member (id, name, age) VALUES (?, ?, ?)";
												
		int result = 0; // insert, update, delete 작업할 때 필요
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO2.URL, // MemberDAO -> private가 되어 있기때문에 넣어 줘야한다.
					MemberDAO2.USERNAME, 
					MemberDAO2.PASSWORD);
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getId());   // 오라클에서 인덱스는 1부터 시작함
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			
			// pstmt.executeQuery();-> SELECT~ 로 시작할 때..
			result = pstmt.executeUpdate(); // SELECT가 아닌 걸로 시작할 때..
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			commitOrRollback(result, conn);
			
			closeAll(null, pstmt, conn);
		}
				
		return result;
	}

	public List<MemberDTO> select() {
		List<MemberDTO> list = new ArrayList<MemberDTO>(); // 메서드의 클이 완성됨
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_member";
		ResultSet rs = null;
				
		try {
			conn = DriverManager.getConnection(
					MemberDAO2.URL, MemberDAO2.USERNAME, 
					MemberDAO2.PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(); 
			// executeQuery() : 데이터베이스에서 데이터를 가져와서 결과 집합을 반환합니다
			// Select 문에서만 실행하는 특징이 있습니다.
			
			while (rs.next()) {
				// 컬럼별칭을 입력해야함
				// 컬럼명만 있으면, 컬럼명이 컬럼별칭이 됨.
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				list.add(new MemberDTO(id, name, age));
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
			
		return list;
	}

	public MemberDTO selectById(int id) {	
		MemberDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM tbl_member WHERE id = ?";
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO2.URL, MemberDAO2.USERNAME, 
					MemberDAO2.PASSWORD);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name = rs.getString(2);
				int age = rs.getInt(3);
				
				dto = new MemberDTO(id, name, age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}		
		
		return dto;
	}

	public int update(MemberDTO dto) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE tbl_member SET name = ?, age = ? WHERE id = ?";
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO2.URL, MemberDAO2.USERNAME,
					MemberDAO2.PASSWORD);
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setInt(3, dto.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			commitOrRollback(result, conn);
			
			closeAll(null, pstmt, conn);
		}
				
		return result;
	}

	public int delete(MemberDTO dto) {
		int result = 0; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE tbl_member WHERE id = ? AND name = ?";
		
		try {
			conn = DriverManager.getConnection(
					MemberDAO2.URL, MemberDAO2.USERNAME,
					MemberDAO2.PASSWORD);
			conn.setAutoCommit(false);//=====================
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//======================================
//			if (result > 0) {
//				try {
//					conn.commit();
//				} catch (SQLException e) {					
//					e.printStackTrace();
//				}
//			} else {
//				try {
//					conn.rollback();
//				} catch (SQLException e) {					
//					e.printStackTrace();
//				}
//			}
			//=========================================
			
			commitOrRollback(result, conn); // 바로 위에 주석처리한 코드를 중복이 되니 메서드로 따로 써서
			                                // 한줄로 만든다.
			
			closeAll(null, pstmt, conn);
		}
				
		return result;
	}
	
}