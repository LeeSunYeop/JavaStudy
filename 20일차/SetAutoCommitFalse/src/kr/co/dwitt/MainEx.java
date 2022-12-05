package kr.co.dwitt;

public class MainEx {

	public static void main(String[] args) {
		
		DepDAO dao = new DepDAO();
		
 		int result = dao.delete2(2);
 		if (result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}

	}

}
