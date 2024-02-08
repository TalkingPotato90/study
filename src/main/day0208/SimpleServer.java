package day0208;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	public void msgServer() throws IOException {
		// 1. 서버 소켓 생성
		ServerSocket server = null;
		Socket client = null;
		DataOutputStream dos = null;
		
		try {
			server = new ServerSocket(7770);
			String msg = "수업 그만 하고 집에 갑시다!";
			while(true) {
				// 3. 접속자 소켓을 받는다.
				client = server.accept();
				
				// 4. 메시지를 보내기 위한 스트림을 소켓에서 얻는다.
				dos = new DataOutputStream(client.getOutputStream());
				
				// 5. 스트림에 메시지 쓰기
				dos.writeUTF(msg);
				
				// 6. 목적지(socket)로 스트림의 내용을 분출
				dos.flush();
			}	// end while
		} finally {
			// 7. 연결 끊기
			if(dos != null) {
				dos.close();
			}	// end if
			if(client != null) {
				client.close();
			}	// end if
			if(server != null) {
				server.close();
			}	// end if
		}	// end finally
		
	}	// msgServer

	public static void main(String[] args) {
		SimpleServer ss = new SimpleServer();
		try {
			ss.msgServer();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class