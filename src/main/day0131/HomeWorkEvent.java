package day0131;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class HomeWorkEvent extends WindowAdapter implements ActionListener, MouseListener {

	private HomeWorkDesign hwd;



	public HomeWorkEvent(HomeWorkDesign hwd) {
		this.hwd = hwd;
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == hwd.getAddButon()) {
			addMember();
		}//end if
		if(ae.getSource() == hwd.getChangeButon()) {
			modifyMember();
		}//end if
		if(ae.getSource() == hwd.getDeleteButon()) {
			removeMember();
		}//end if
		if(ae.getSource() == hwd.getEndButon()) {
			closeWin();
		}//end if
	}//actionPerformed

	@Override
	public void windowClosing(WindowEvent we) {
		hwd.dispose();
	}//windowClosing


	@Override
	public void mouseClicked(MouseEvent me) {

	}//mouseClicked


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {

	}


	@Override
	public void windowActivated(WindowEvent e) {
		//윈도우가 켜지면 마우스 커서가 JtfName으로 자동으로 위치하게 만듦
		hwd.getJtfName().requestFocus();
	}

	//추가시키는 메소드 생성
	private void addMember() {
		JTextField jtfName = hwd.getJtfName(); //이름은 hwd의 이름
		JTextField jtfCallNum = hwd.getJftCallNum();
		JRadioButton jrbMan = hwd.getMan();
		JRadioButton jrbWman = hwd.getWman();
		JComboBox<String> jcbAge = hwd.getJcbAge();
		DefaultComboBoxModel<String> age = hwd.getAge();
		DefaultListModel<String> dlmData = hwd.getDlmData();

		//유효성 검증
		String name = jtfName.getText().trim();
		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(hwd, "이름은 필수 입력입니다.");
			jtfName.requestFocus(); //마우스 커서 다시 이름에
			return; //얼리 리턴
		}//end if

		//MVC Pattern 도입된 컴포넌트
		String selectedAge = age.getElementAt(jcbAge.getSelectedIndex());

		String gender = "";
		if(jrbMan.isSelected()) { //남자버튼이 클릭되었으면
			gender = jrbMan.getText(); //젠더는 남자버튼의 텍스트를 얻음
		}//end if

		String tel = jtfCallNum.getText().trim();


		//유효성 검증 성공 후 데이터를 채우는 일
		StringBuilder sbSetData = new StringBuilder(); //데이터 스트링빌더 생성
		sbSetData.append(name).append(","); //데이터에 이름과 콤마를 넣음
		sbSetData.append(selectedAge).append(",");
		sbSetData.append(gender).append(",");
		sbSetData.append(tel).append(",");

		//JList에 설정
		dlmData.addElement(sbSetData.toString());

		//컴포넌트를 초기화
		jtfName.setText("");
		jtfCallNum.setText("");
		jrbWman.setSelected(true);;
		jcbAge.setSelectedIndex(0);

		jtfName.requestFocus();
	}//addMember

	//변경시키는 메소드 생성
	private void modifyMember() {
		//이름, 나이, 전화번호를 입력받아 이름과 같은 사람의 나이와 전화번호를 변경
		JTextField jtfName = hwd.getJtfName(); //이름은 hwd의 이름
		JTextField jtfCallNum = hwd.getJftCallNum();
		JComboBox<String> jcbAge = hwd.getJcbAge();
		DefaultComboBoxModel<String> age = hwd.getAge();
		DefaultListModel<String> dlmData = hwd.getDlmData();

		//유효성 검증
		String name = jtfName.getText().trim();
		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(hwd, "이름은 필수 입력입니다.");
			jtfName.requestFocus(); //마우스 커서 다시 이름에
			return; //얼리 리턴
		}//end if

		//MVC Pattern 도입된 컴포넌트
		String selectedAge = age.getElementAt(jcbAge.getSelectedIndex());
		String tel = jtfCallNum.getText().trim();

		String item = "";
		StringBuilder sbSetData = new StringBuilder();
		String gender = "";
		for(int i = 0; i < dlmData.size(); i++) {
			//리스트에서 값을 얻어
			item = dlmData.getElementAt(i);
			//이름이 같은지 (입력된 이름으로 시작하니?)
			if(item.startsWith(name)) {
				//시작한다면 입력된 값과 기존의 값을 사용하여 변경한다.
				gender = item.split(",")[2]; //기존의 값

				sbSetData.append(name).append(",")
						.append(selectedAge).append(",")
						.append(gender).append(",").append(tel);
				//현재 번째의 아이템을 삭제
				dlmData.removeElementAt(i);
				//현재 번째의 변경된 값을 설정한다.
				dlmData.add(i, sbSetData.toString());

			}//end if
		}//end for
	}//modifyMember

	//삭제시키는 메소드 생성
	private void removeMember() {
		//입력된 이름에 해당하는 아이템을 JList에서 삭제
		JTextField jtfName = hwd.getJtfName(); //이름은 hwd의 이름
		DefaultListModel<String> dlmData = hwd.getDlmData();

		//유효성 검증
		String name = jtfName.getText().trim();
		if(name.isEmpty()) {
			JOptionPane.showMessageDialog(hwd, "이름은 필수 입력입니다.");
			jtfName.requestFocus(); //마우스 커서 다시 이름에
			return; //얼리 리턴
		}//end if

		//친구리스트에서 모든 값을 가져와서
		Object[] obj = new Object[dlmData.size()]; //배열 생성
		obj = dlmData.toArray(); //친구리스트의 모든 값을 배열로 복사
		String item = "";
		//리스트의 모든 값을 삭제하고
		dlmData.removeAllElements();
		for(int i = 0; i < obj.length; i++) {
			//친구리스트에 넣고
			item = (String)obj[i];
			if(!item.startsWith(name)) { //이름으로 시작하지 않는 값만 설정한다.
				dlmData.addElement(item);
			}//end if
		}//end for

	}//removeMember

	//종료시키는 메소드 생성
	private void closeWin() {
		hwd.dispose();
	}//closeWin

}//class
