package kr.co.member.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.member.domain.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession session;
	private final String NS = "kr.co.member";
	// NS -> namespace
	
	@Override
	public void insert(MemberDTO dto) {
		
		session.insert(NS+".insert", dto);
		
	}
	
	@Override
	public MemberDTO read(String id) {
		
		return session.selectOne(NS+".read", id);
	}
	
	public void update(MemberDTO dto) {
		
		session.update(NS+".update", dto);
		
	}

	@Override
	public int changePw(Map<String, Object> map) {
		
		return session.update(NS+".changPw", map);
	}
	
	
}
