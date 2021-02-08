package simp.test2;

import java.net.ServerSocket;
import java.net.Socket;

public class Test {

	public Test() {}

	public void serverStart() {
		// 1. port 번호 지정
		int port = 3000;
		// 2. 서버용 소켓 객체 생성
		ServerSocket server;
		try {
			server = new ServerSocket(port);
			// 3. 클라이언트가 연결을 요청할 때까지 기다림
			while (true) {
				// 4. 연결을 요청한 클라이언트의 요청 수락함 : 해당 클라이언트 정보를 저장

				Socket client = server.accept();

				// 중간 생략....

			}
		} catch(Exception e) {
		}
	}

}
