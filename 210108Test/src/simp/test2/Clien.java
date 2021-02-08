package simp.test2;

import java.net.InetAddress;
import java.net.Socket;

public class Clien {
	public void fileUpload() {
		int port = 3000;
		String serverIP;
		try {
		serverIP = InetAddress.getLocalHost().getHostAddress();

		// 2. 소켓 객체 생성 : 생성과 동시에 서버에 연결 요청됨

		Socket socket = new Socket(serverIP, port);

		// 연결 실패는 null 리턴됨

		//이하 코드 중간 생략.....

		} catch(Exception e) {
		}
	}
}
