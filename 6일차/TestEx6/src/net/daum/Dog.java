package net.daum;

public class Dog {
	
	int a = 0;
	
	public long arop11(int a, int b) {
		// 산술연산자: +
		// 오버플로우, 언더플로우를 조심해라
		// long을 써야한다, 형변환해야함
		
		long result = (long)a + b;
				
		return result;
	}
	
	public int arop1(int a, int b) {
		// 산술연산자: +
				
		int result = a + b;
				
		return result;
	}
	
	public void arop3(int a, int b) {
		// 산술연산자: -
				
		int result = a - b;
		System.out.println(result);				
	}
	
	public void arop4(int a, int b) {
		// 산술연산자: *
				
		int result = a * b;
		System.out.println(result);				
	}
	
	public void arop5(int a, int b) {
		// 산술연산자: /(몫연산자)  int형을 사용하면 몫만 나옴
				
		int result = a / b;
		System.out.println(result);				
	}
	
	public void arop6(double a, double b) {
		// 산술연산자: /      // double형을 사용하면 실수로 나옴
				
		double result = a / b;
		System.out.println(result);				
	}
	
	public void arop7(int a, int b) {
		// 산술연산자: %(나머지 연산자)
				
		int result = a % b;
		System.out.println(result);				
	}
	
	public void asop1(int a, int b) {
		// 대입연산자: =
				
		a = b;
						
	}
	
	public void coop1(int a, int b) {
		// 복합연산자: 산술연산자와 대입연산자를 조합해서 만듬..				
	    // +=, -=, *=, /=, %=
		
		a += b;
		// a + b 하고 a에 그 결과를 대입
		System.out.println(a);
		System.out.println(b);
	}
	
	public void coop2(int a, int b) {						
	    // +=, -=, *=, /=, %=
		
		a -= b;
		// a - b 하고 a에 그 결과를 대입
		System.out.println(a);
		System.out.println(b);
	}
	
	public void coop3(int a, int b) {		
	    // +=, -=, *=, /=, %=
		
		a *= b;
		// a * b 하고 a에 그 결과를 대입
		System.out.println(a);
		System.out.println(b);
	}
	
	public void coop4(int a, int b) {		
	    // +=, -=, *=, /=, %=
		
		a /= b;
		// a / b 하고 a에 그 결과를 대입
		System.out.println(a);
		System.out.println(b);
	}
	
	public void coop5(int a, int b) {		
	    // +=, -=, *=, /=, %=
		
		a %= b;
		// a % b 하고 a에 그 결과를 대입
		System.out.println(a);
		System.out.println(b);
	}
	
	public void idop1(int a) {		
	    // 증감연산자: ++  -> a = a + 1
		
		System.out.println(a);  // 10나옴
		
		++a;		
		System.out.println(a);	// 11나옴	 
	}
	
	public void idop2(int a) {		
	    // 증감연산자: --  -> a = a - 1
		
		System.out.println(a);  // 10나옴
		
		--a;		
		System.out.println(a);	// 9나옴	
	}
	
	public void idop3(int a, int b) {		
	    // ++a , b++ 차이점
		
		System.out.println(a);  // 10나옴
		System.out.println(b);  // 10나옴
				
		System.out.println(++a);  // 11나옴  즉시 증감
		System.out.println(b++);  // 10나옴  나중에 해당 변수를 만났을 때, 증감값을 대입
		
		System.out.println(a);  // 11나옴
		System.out.println(b);  // 11나옴  
	}
	
	public void comop1(int a, int b) {		
	    // 비교연산자 >  true 나 false로 나옴
		boolean result = a > b;
		System.out.println(result);  			
	}
	
	public void comop2(int a, int b) {		
	    // 비교연산자 >=  true 나 false로 나옴
		boolean result = a >= b;
		System.out.println(result);  			
	}
	
	public void comop3(int a, int b) {		
	    // 비교연산자 <  true 나 false로 나옴
		boolean result = a < b;
		System.out.println(result);  			
	}
	
	public void comop4(int a, int b) {		
	    // 비교연산자 <=  true 나 false로 나옴
		boolean result = a <= b;
		System.out.println(result);  			
	}
	
	public void comop5(int a, int b) {		
	    // 비교연산자 ==  true 나 false로 나옴
		boolean result = a == b;
		System.out.println(result);  			
	}
	
	public void comop6(int a, int b) {
		// 비교연산자 !=  true 나 false로 나옴
		boolean result = a != b;
		System.out.println(result);
	}
	
	public void loop1(boolean a, boolean b) {
		// 논리연산자 &&(and)  true 나 false로 나옴
		boolean result = a && b;
		System.out.println(result);
	// 만약 앞의 값이 false로 먼저 나오면 뒤에 뭐가잇든 보지도 않고 false로 출력됨
	}
	
	public void loop2(int a, int b) {
		// 논리연산자 &&  true 나 false로 나옴
		boolean result = (a>b) && (a % b == 3);
		System.out.println(result);
	}
	
	public void loop3(boolean a, boolean b) {
		// 논리연산자 ||(or)  true 나 false로 나옴
		boolean result = a || b;
		System.out.println(result);
	}
	
	public void loop4(boolean a) {
		// 논리연산자 !(not)  true 나 false로 나옴
		System.out.println(a);
		a = !a;   // switch 알고리즘.
		System.out.println(a);
	}
	
	public void arop7() {
		// switch 알고리즘.
		a = 1 - a;
		System.out.println(a);
		// 출력 1 0 1 0 1 
	}
	
	public void biop1() {
		// 비트연산자 &
		boolean result = true & true;
		System.out.println(result);
	}
	
	public void biop2() {
		// 비트연산자 &
		int a = 2;
		int b = 5;
		
		int result = a & b;
		System.out.println(result);
		// 출력 0 나옴
		//   0   1    0 -> 2를 2진수하면
		// & 1   0    1 -> 5를 2진수하면
		//  0&1 1&0  0&1
		//   0   0    0
	}
	
	public void biop3() {
		// 비트연산자 |
		boolean result = false | true;
		System.out.println(result);
	}
	
	public void biop4() {
		// 비트연산자 |
		int a = 2;
		int b = 5;
		int result = a | b;
		System.out.println(result);
		// 출력 7 나옴
		//   0   1    0 -> 2를 2진수하면
		// | 1   0    1 -> 5를 2진수하면
		//  0|1 1|0  0|1
		//   1   1    1
		// 1*2*2 + 1*2 + 1*1 
	}
	
	public void biop5() {
		// 비트연산자 ^
		// exclusive or
		// 베타적 or
		// xor
		boolean result1 = true ^ true;
		boolean result2 = true ^ false;
		boolean result3 = false ^ false;
		boolean result4 = false ^ true;
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
	
	public void biop6() {
		// 비트연산자 ^
		int a = 2;
		int b = 4;
		// 다르면 1, 같으면 0
		System.out.println(a^b);
	}
	
	public void biop7() {
		// 비트연산자 ~(not): 부호 반전 후 -1을 추가 연산
		int a = 4;
		int b = 3;
		int c = 2;
		int d = 1;
		int e = 0;
		int f = -1;
		int g = -2;
		int h = -3;
		int i = -4;
		System.out.println(~a);  // -5
		System.out.println(~b);  // -4
		System.out.println(~c);  // -3
		System.out.println(~d);  // -2
		System.out.println(~e);  // -1
		System.out.println(~f);  //  0
		System.out.println(~g);  //  1
		System.out.println(~h);  //  2
		System.out.println(~i);  //  3  나옴		
	}
	
	public void shop1() {
		// shift 연산자: << 숫자를 연산할 때는 2진수로 변경후 작업
		int a = 2;
		int result1 = a << 1;
		int result2 = a << 2;
		int result3 = a << 3;
		int result4 = a << 4;
		
		System.out.println(Integer.toBinaryString(a)); // 1 0 나옴 -> 2진수 2를 나타냄
		System.out.println(result1);  // 4
		System.out.println(result2);  // 8
		System.out.println(result3);  // 16
		System.out.println(result4);  // 32 나옴
		
		//       1 0   -> 2를 2진수한거
		//     1 0    << 1 왼쪽으로 1칸이동 1*2*2 + 0 + 0
		//   1 0      << 2 왼쪽으로 2칸이동 1*2*2*2 + 0 + 0 + 0
		// 1 0        << 3 왼쪽으로 3칸이동 1*2*2*2*2 + 0 + 0 + 0 + 0
		// 이렇게 나열이 된다
	}
	
	public void shop2() {
		// shift 연산자: >>
		int a = 16;
		int result1 = a >> 1;
		int result2 = a >> 2;
		int result3 = a >> 3;
		int result4 = a >> 4;
		
		System.out.println(Integer.toBinaryString(a)); // 1 0 0 0 0 나옴 -> 16을 2진수로 나타냄
		System.out.println(result1);  // 8
		System.out.println(result2);  // 4
		System.out.println(result3);  // 2
		System.out.println(result4);  // 1  나옴
		
		// 1 0 0 0 0   -> 16을 2진수한거
		//   1 0 0 0      >> 1 오른쪽으로 1칸이동  8
		//     1 0 0      >> 2 오른쪽으로 2칸이동  4
		//       1 0      >> 3 오른쪽으로 3칸이동  2
		// 이렇게 나열이 된다
	}
	
	public void ifop1(int a) {
		// 삼항연산자(조건연산자)
		boolean result = a > 3? true : false;
		System.out.println(result);
		// a에 3이 들어가면 3 > 3? 크냐? false로 출력됨
	}
	
	public void ifop2(int a) {
		// 삼항연산자(조건연산자)
		// a가 2의 배수이면 "합격" 그렇지 않으면 "불합격"을 변수 pass에 대입하세요
		 
		 String pass = a % 2 == 0? "합격" : "불합격";
		 System.out.println(pass);
	}
	
	public void ifop3(int a, int b) {
		// a가 b보다 크면 'a' 그렇지 않으면 'b'가 result변수에 입력됨
		char result = a > b? 'a' : 'b';
		System.out.println(result);
	}
	
	public void t1() {
		System.out.println("no");
	}
	
	public int t2() {
		return 3;
	}
	
	public void ifop4() {
		int result = 3 == 4? t2() : 3 ;
		// t2()는 같은 int형이라 오류가 안나지만
		// t1()은 오류가 뜬다
	}
	
	public void ifop5(int a) {
		// 삼항연산자 안에 삼항연사자를 넣은 경우
		// a>4 -> 'a'
		// a==4 -> 'b'
		// a<4 -> 'c'
		char result = a > 4 ? 'a' : a==4? 'b' : 'c';
	}
	
	public void ifop6(int score) {
		char result = score >= 90? '수' : 
			score >= 80? '우' : 
				score >= 70? '미' : 
					score >= 60? '양' : '가';
		System.out.println(result);
	}
	
	
	
}
