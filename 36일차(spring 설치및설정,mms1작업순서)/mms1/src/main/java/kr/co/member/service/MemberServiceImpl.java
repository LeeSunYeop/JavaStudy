package kr.co.member.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.member.domain.MemberDTO;
import kr.co.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO mDao;
	
	@Override
	public void insert(MemberDTO dto) {
		mDao.insert(dto);
		
	}

}
