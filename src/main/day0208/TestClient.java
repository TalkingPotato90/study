package day0208;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 소켓을 생성하여 서버에 연결하는 일
 */
public class TestClient {
	
	public TestClient() throws UnknownHostException, IOException {
		// 1. Socket 생성) 설정한 IP와 port로 서버에 연결
		Socket client = new Socket("192.168.10.231", 36000);
		System.out.println("서버에 연결 성공");
	}	// TestClient

	public static void main(String[] args) {
		try {
			new TestClient();
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class