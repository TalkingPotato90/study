package day0129;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class TestWindowEvent extends Frame implements WindowListener {
	public TestWindowEvent() {
		super("윈도우 이벤트 연습");
		
		//Window component를 이벤트에 등록
		addWindowListener(this);
		
		
		setSize(400,400);
		setVisible(true);
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();//dispose > windowClosed 호출
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
		
	}

	public static void main(String[] args) {
		new TestWindowEvent();
	}
}
