package day0213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea jtaTalkDisplay;
	private JTextField jtfTalk;
	private JScrollPane jspTalk;
	
	private Socket someClient;
	private DataInputStream disReadStream;
	private DataOutputStream dosWriteStream;
	
	public SimpleChatClient() {
		super(":::::::채팅클라이언트:::::::");
		jtaTalkDisplay=new JTextArea();
		jtaTalkDisplay.setEditable(false);
		jtfTalk=new JTextField();
		jspTalk=new JScrollPane( jtaTalkDisplay);
		
		jspTalk.setBorder(new TitledBorder("대화내용"));
		jtfTalk.setBorder(new TitledBorder("대화"));
		
		add("Center", jspTalk);
		add("South", jtfTalk);
		
		
		setBounds(100, 100, 500, 600);
		setVisible(true);
		
		try {
			connectToServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		jtfTalk.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					closeClient();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					dispose();
				}
			}
		});
		
	}//SimpleChatServer
	
	
	private void closeClient() throws IOException {
		if (dosWriteStream != null) {dosWriteStream.close();}
		if (disReadStream != null) {disReadStream.close();}
		if (someClient != null) {someClient.close();}
		
	}
	
	private void connectToServer() throws UnknownHostException, IOException {
		//2.소켓 생성 // 서버로 연결을 시도
		someClient = new Socket("192.168.10.229",2024);//loop back
		
		//4.데이터를 주고, 받을 수 있도록 스트림을 연결
		disReadStream = new DataInputStream(someClient.getInputStream());
		dosWriteStream = new DataOutputStream(someClient.getOutputStream());
		
		Thread t = new Thread(this);
		t.start(); 
	}
	
	/**
	 * 접속자가 배내오는 메시지를 계속 읽어 들인다.
	 * @throws IOException 
	 */
	@Override
	public void run(){
		if(disReadStream != null) {
			String msg="";
			try {
			while(true) {
				//메시지를 동시에 읽어들여 J.T.A에 출력
				msg = disReadStream.readUTF();
				jtaTalkDisplay.append(msg+"\n");
			}
			}catch(IOException ie) {
				JOptionPane.showMessageDialog(this, "접속자가 연결을 종료하였습니다.");
				ie.printStackTrace();
			}
		}
	}
	
	private void sendMsg() throws IOException {
		if(dosWriteStream == null) {
			JOptionPane.showInternalMessageDialog(this, "서버에 연결 전입니다.");
			return;
		}
		
		String msg = jtfTalk.getText();
		
		if(!msg.isEmpty()) {
			//메시지를 스트림에 쓰기
			dosWriteStream.writeUTF("진수현 : " + msg);
			//스트림의 내용을 목적지로 분출
			dosWriteStream.flush();
			//J.T.F를 초기화
			jtfTalk.setText("");
		}
	}
	
	
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}//actionPerformed

	public static void main(String[] args) {
//		SimpleChatClient scc = new SimpleChatClient();
//		try {
//			scc.connectToServer();
//		} catch (UnknownHostException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
		
		 new SimpleChatClient();
		
		
	}//main

}//class
