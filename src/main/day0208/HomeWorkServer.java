package day0208;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class HomeWorkServer {
	
	public void msgServer() throws IOException {
		ServerSocket server = null;
		Socket client = null;
		DataInputStream dis = null;
		
		try {
			server = new ServerSocket(8000);			
			client = server.accept();
			dis = new DataInputStream(client.getInputStream());
			
			String msg = "";
			while(true) {
				msg = dis.readUTF();
				JOptionPane.showMessageDialog(null, "Client의 메세지: " + msg);
			}	// end while
		} finally {
			if(dis != null) {
				dis.close();
			}	// end if
			if(client != null) {
				client.close();
			}	// end if
			if(server != null) {
				server.close();
			}	// end if
		}	// end if
	}	// msgServer

	public static void main(String[] args) {
		HomeWorkServer hws = new HomeWorkServer();
		try {
			hws.msgServer();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class