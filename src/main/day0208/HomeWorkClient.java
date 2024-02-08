package day0208;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HomeWorkClient {
	
	public void msgClient() throws IOException {
		Socket client = null;
		DataOutputStream dos = null;
		
		try {
			client = new Socket("192.168.10.232", 8000);
			String msg = "빨리 하고 집에 갑시다~";
			
			dos = new DataOutputStream(client.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		} finally {
			if(dos != null) {
				dos.close();
			}	// end if
			if(client != null) {
				client.close();
			}	// end if
		}	// end finally
	}	// msgClient

	public static void main(String[] args) {
		HomeWorkClient hwc = new HomeWorkClient();
		try {
			hwc.msgClient();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main 

}	// class