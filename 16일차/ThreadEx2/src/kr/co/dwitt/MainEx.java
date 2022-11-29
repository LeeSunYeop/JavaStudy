package kr.co.dwitt;

import com.naver.Board;

import net.daum.ReaderThread;
import net.daum.WriterThread;

public class MainEx {

	public static void main(String[] args) {
		// 접근순서에 의한 스레드 동기화..
		// 스레드 동기화 syncronized
		// 홍길동, 김유신
		// 홍길동이 김유신한테 돈을 빌려달라고 했어요.
		// 김유신이 빌려준다고 했습니다.
		// 홍길동이 계좌에 접속을 합니다.
		// 아직 김유신은 돈을 안 보냈습니다.
		// 홍길동 계좌에 돈이 안 들어와 있겠죠. 그러면 스레드는 종료
		// 김유신이 지금 돈을 보냅니다... 그러면서 김유신의 스레드도 종료
		// 이런 문제점을 해결하기 위해서, 접근순서에 의한 스레드 동기화가 필요합니다.
		// 홍길동 스레드가 먼저 running됨, 그런데 아직 김유신 스레드가 돈을 안 보냈어.
		// 홍길동 스레드는 대기상태로 빠짐...(blocked상태 X, 대기상태)
		// 김유신 스레드가 돈을 보냅니다. 대기상태에 있는 스레드들을 깨우는 작업을 합니다. notify()메서드 호출
		// 대기상태에 있는 홍길동 스레드가 깨어나고, 작업을 이어서 합니다.
		
		Board board = new Board();
		
		ReaderThread rt = new ReaderThread(board);
		Thread wt = new WriterThread(board);
		
		rt.start();
		
		wt.start();

	}

}
