package kr.co.sist.chat.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.client.MultiChatClient;

@SuppressWarnings("serial")
public class MultiChatServer extends JFrame implements ActionListener, Runnable {
	
	private JButton jbtnStartServer, jbtnclose;
	private DefaultListModel<String> dlmConnect;
	private JScrollPane jspConnectList;
	private ServerSocket server;
	private Thread threadServer;
	public static List<ChatHelper> listConnect;
	
	public MultiChatServer() {
		super("채팅서버");
		
		listConnect = new ArrayList<ChatHelper>();	// ChatHelper 동시접근 O(메시지 꼬일 확률 있음), 빠름
//		listConnect = new Vector<ChatHelper>();		// ChatHelper 동시접근 X(메시지 꼬일 확룰 없음), 느림
		
		jbtnStartServer=new JButton("서버가동");
		jbtnclose=new JButton("서버종료");
		dlmConnect=new DefaultListModel<String>();
		JList<String> jlConnect=new JList<String>( dlmConnect );
		jspConnectList=new JScrollPane(jlConnect);
		
		jspConnectList.setBorder(new TitledBorder("접속자 리스트"));
		JPanel jpSouth=new JPanel();
		jpSouth.add(jbtnStartServer);
		jpSouth.add(jbtnclose);
		
		add("Center", jspConnectList);	
		add("South", jpSouth);
		
		jbtnStartServer.addActionListener(this);
		jbtnclose.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					closeWin();
				} catch (IOException e1) {
					e1.printStackTrace();
				}	// end catch
			}	// windowClosing

			@Override
			public void windowClosed(WindowEvent e) {
				System.exit(JFrame.ABORT); // 프로그램의 가장 마지막에 System.exit 사용
			}	// windowClosed
		});	// addWindowListener
		
		setBounds(100, 100, 400, 700);
		setVisible(true);
	} //MultiChatServer
	
	public void closeWin() throws IOException {
		try {
			if(server != null) {
				server.close();
			}	// end if
		} finally {
			dispose();
		}	// end finally
	}	// closeWin

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == jbtnStartServer) {
			if(threadServer != null) {	// threadServer가 사용 중이라면
				JOptionPane.showMessageDialog(this, "서버가 가동 중입니다.");
				return;
			}	// end if
			threadServer = new Thread(this);
			threadServer.start();	// run 호출
		}	// end if
		if(ae.getSource() == jbtnclose) {
			try {
				closeWin();
			} catch (IOException e) {
				e.printStackTrace();
			}	// catch
		}	// end if
	}	// actionPerformed
	
	@Override
	public void run() {
		// 윈도우 디자인과 소켓의 접속을 동시에 사용할 수 있게 된다.
		try {
			server = new ServerSocket(2024);
			dlmConnect.addElement("서버가 정상적으로 실행되었습니다.");
			
			Socket tempClient = null;
			ChatHelper tempCh = null;
			
			for(int cnt = 1; ; cnt++) {	// 접속 인원 모름
				tempClient = server.accept();
				tempCh = new ChatHelper(tempClient, cnt, dlmConnect);	// Thread
				listConnect.add(tempCh);
				tempCh.start(); // 접속자가 보내오는 메시지를 무한루프로 읽는다. => tempCh의 run() 호출
				
				// 스크롤바를 마지막으로 이동
				jspConnectList.getVerticalScrollBar().setValue(jspConnectList.getVerticalScrollBar().getMaximum());
			}	// end for
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "서버 가동 중 문제가 발생했습니다.\n프로그램을 종료한 다음 다시 실행해주세요.");
			e.printStackTrace();
		}	// end catch
	}	// run
	
}	// class