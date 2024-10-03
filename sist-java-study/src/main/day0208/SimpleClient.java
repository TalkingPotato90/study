package day0208;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SimpleClient {
	
	public void msgClient() throws IOException {
		Socket client = null;
		DataInputStream dis = null;
		
		try {
			String ip = JOptionPane.showInputDialog("서버의 ip를 입력해주세요.\n사용가능 ip)210~232");
			// 2. 소켓 생성 => 서버에 연결(3way handshaking)하여 회선 확립 시도
			client = new Socket("192.168.10."+ip, 7770);

			// 4. 스트림 연결
			dis = new DataInputStream(client.getInputStream());
			
			// 7. 값 얻기
			String msg = dis.readUTF();
			JOptionPane.showMessageDialog(null, "친구의 메세지: " + msg);
		} finally {
			// 8. 연결 끊기
			if(dis != null) {
				dis.close();
			}	// end if
			if(client != null) {
				client.close();
			}	// end if
		}	// end finally
		
	}	// msgClient

	public static void main(String[] args) {
		SimpleClient sc = new SimpleClient();
		try {
			sc.msgClient();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class