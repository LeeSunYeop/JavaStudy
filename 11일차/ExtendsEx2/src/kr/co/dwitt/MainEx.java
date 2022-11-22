package kr.co.dwitt;

import com.appl.MemberDTO;
import com.google.Cannon;
import com.google.Gun;

public class MainEx {

	public static void main(String[] args) {
		
		Cannon daepo = new Cannon("1", "대포", 100);
		daepo.attack();
		
		Gun gun = new Gun("2", "권총", 50);
		gun.attack();
		
		
		
//		MemberDTO dto = new MemberDTO();
//		
//		System.out.println(dto);
//		System.out.println(dto.toString());
//		
//		MemberDTO dto2 = new MemberDTO(1, "김");
//		System.out.println(dto2);
//		System.out.println(dto2.toString());
		

	}

}
