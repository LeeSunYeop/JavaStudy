package kr.co.member.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.member.domain.MemberDTO;

@ Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession session;
	private final String NS = "kr.co.member";
	// NS -> namespace
	
	@Override
	public void insert(MemberDTO dto) {
		session.insert(NS+".insert", dto);
		
	}
	
}
