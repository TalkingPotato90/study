package day0208;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 포트를 열어서 접속자 소켓을 받는 서버 구현
 */
public class TestServer {
	
	public TestServer() throws IOException {
		// 1. ServerSocket 생성) - TCP/IP를 사용
		ServerSocket server = new ServerSocket(36000);
		
		// 2. 접속자 소켓을 받아서 사용)
		Socket client = server.accept();	// 접속자가 있을 때에만 동작
		System.out.println("접속자 접속 " + client.getInetAddress());
	}	// TestServer

	public static void main(String[] args) {
		try {
			new TestServer();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class