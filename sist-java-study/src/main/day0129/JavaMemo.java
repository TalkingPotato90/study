package day0129;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class JavaMemo extends JFrame{

	public JavaMemo() {
		super("메모장");
		
		// texarea / 스크롤바 생성
		JTextArea jta = new JTextArea();
		JScrollPane jsp = new JScrollPane(jta);
		
		add(jsp);
		//  메뉴바 생성
		JMenuBar jmb = new JMenuBar();
		
		//  메뉴 생성
		JMenu jm1 = new JMenu("파일");
		JMenu jm2 = new JMenu("도움말");
		
		// 메뉴 아이템 생성
		JMenuItem jmi1_1 = new JMenuItem("새글");
		JMenuItem jmi1_2 = new JMenuItem("열기");
		JMenuItem jmi1_3 = new JMenuItem("저장");
		JMenuItem jmi1_4 = new JMenuItem("종료");
		
		JMenuItem jmi2_1 = new JMenuItem("메모장 정보");
		
		//  메뉴 아이템을 메뉴 배치
		jm1.add(jmi1_1);
		jm1.add(jmi1_2);
		jm1.add(jmi1_3);
		jm1.add(jmi1_4);
		
		jm2.add(jmi2_1);
		
		// 메뉴를 메뉴바에 배치
		jmb.add(jm1);
		jmb.add(jm2);
		
		
		// 메뉴 아이템을 프레임에 설정
		setJMenuBar(jmb);
		
		setSize(800,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JavaMemo();
	}

}
