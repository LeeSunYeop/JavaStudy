package kr.co.member.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.member.domain.MemberDTO;
import kr.co.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService mService;
	// MemberService 인터페이스로 만들어야한다.
	
	@RequestMapping(value = "/checkid", method = RequestMethod.POST)
	@ResponseBody
	public String checkId(@RequestParam Map<String, Object> map) {
		
		MemberDTO dto = mService.checkId(map);
		int result = 0;
		
		if (dto == null) {
			result = 1;
		}
		
		return result+"";
	}
	
	@RequestMapping(value = "/changepw", method = RequestMethod.POST)
	@ResponseBody
	public String changePw(@RequestParam Map<String, Object> map) {
		
		int result = mService.changePw(map);		
		
		return result+""; 
		// String으로 반환을 해야하는데 int로 되어있어서 +"" 해주면 String으로 된다.
		// 실제데이터 값이며 이 값은 read jsp에 있는 result로 넘어간다.
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemberDTO dto, Model model) {
		
		dto = mService.update(dto);
		model.addAttribute("dto", dto);
		
		return "redirect:/member/read/"+dto.getId();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") String id, Model model) {
		
		MemberDTO dto = mService.updateui(id);
		model.addAttribute("dto", dto);
		
		return "member/update";
		
	}
	
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public String read(@PathVariable("id") String id, Model model) {
		
		MemberDTO dto = mService.read(id);		
		model.addAttribute("dto", dto);
		
		return "member/read";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemberDTO dto) {
		// 입력받은걸 불러와야하는데(getparameter) spring에서는 그럴 필요가 없으며
		// MemberDTO dto 입력만 해주면 된다.
		
		mService.insert(dto);
				
		return "redirect:/member/read/"+dto.getId();
		// 리다이렉트방식
		// /member/read/m001 이런식으로 넘어감		
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	// GET방식이기 때문에 일반적으로 ui를 넣지 않는다. 
	public String insert() {
		
		
		return "member/insert";  
		// 디스팻쳐방식
		// servlet-context에서 설정을 해놔서 앞뒤 경로가 저절로 생긴다.
		//<beans:property name="prefix" value="/WEB-INF/views/" />
		//<beans:property name="suffix" value=".jsp" />
	}
}
