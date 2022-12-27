package kr.co.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.member.domain.MemberDTO;
import kr.co.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService mService;
	// MemberService 인터페이스로 만들어야한다.
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberDTO dto) {
		// 입력받은걸 불러와야하는데(getparamter) spring에서는 그럴 필요가 없으며
		// MemberDTO dto 입력만 해주면 된다.
		
		mService.insert(dto);
				
		return "redirect:/member/read/"+dto.getId();
		// /member/read/m001 이런식으로 넘어감		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	// GET방식이기 때문에 일반적으로 ui를 넣지 않는다. 
	public String insert() {
		
		
		return "member/insert";  
		// servlet-context에서 설정을 해놔서 앞뒤 경로가 저절로 생긴다.
		//<beans:property name="prefix" value="/WEB-INF/views/" />
		//<beans:property name="suffix" value=".jsp" />
	}
}
