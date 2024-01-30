package day0129;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class StudentInfo extends JFrame{

	public StudentInfo() {
		super("숙제");
		setLayout(null);
		addInfo();
		addText();
		addComboBox();
		addRadioButton();
		addList();
		addButton();


		//컴포넌트 설정
		setSize(400,290);
		setResizable(false);//크기변경을 막음
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void addInfo() {
		String[] userInfo = {"이름", "나이", "성별", "전화번호"};
		JLabel[] jlArr = new JLabel[4];
		for(int i = 0; i < jlArr.length; i++) {
			jlArr[i] = new JLabel(userInfo[i]);
			jlArr[i].setBounds(20, (i)*40, 180, 50);
			add(jlArr[i]);
		}	// end for
	}

	public void addText() {
		JTextField jtfName = new JTextField(10);
		JTextField jtfPhoneNumber = new JTextField(15);
		jtfName.setBounds(60, 13, 150, 30);
		jtfPhoneNumber.setBounds(75, 130, 150, 30);
		add(jtfName);
		add(jtfPhoneNumber);
	}

	public void addComboBox() {

		// 콤보박스 Model 객체 생성
		DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<String>();
		//  콤보박스 Model 객체와 has a 관계 View 객체 생성
		JComboBox<String>jcb = new JComboBox<String>(dcbm);
		for(int i=20 ; i<=40 ; i++) {
			dcbm.addElement(String.valueOf(i));
		}
		jcb.setBounds(60, 56, 100, 20);

		add(jcb);
	}

	public void addRadioButton() {
		JRadioButton jrbMen = new JRadioButton("남자");
		JRadioButton jrbWomen = new JRadioButton("여자");
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbMen);
		bg.add(jrbWomen);
		jrbMen.setBounds(60, 90, 60, 30);
		jrbWomen.setBounds(120, 90, 80, 30);
		add(jrbMen);
		add(jrbWomen);
	}

	public void addList() {
		// 리스트 모델 객체 생성
		DefaultListModel<String>dlm = new DefaultListModel<String>();
		//  View생성 => 리스트 Model과 has a 관계
		JList<String> jl = new JList<String>(dlm);
		//리스트에 값넣기
		dlm.addElement("1,진수현,남,010-1234-5678");
		dlm.addElement("2,김동섭,남,010-1234-5678");
		dlm.addElement("3,김병년,남,010-1234-5678");
		dlm.addElement("4,이예찬,남,010-1234-5678");

		JScrollPane jsp=new JScrollPane(jl);

		jsp.setBounds(250, 30, 120, 120);
		add(jsp,BorderLayout.EAST);
	}

	public void addButton() {
		String[]btn = {"추가","변경","삭제","종료"};
		JButton[]jbtArr = new JButton[4];

		JPanel jp=new JPanel();
//		jp.setLayout(null);

		for(int i = 0; i < jbtArr.length ; i++) {
			jbtArr[i] = new JButton(btn[i]);
			jbtArr[i].setBounds((i*70), 180, 60, 30);
			add(jbtArr[i]);
		}

		jp.setBounds(50,180,260,50);
		add(jp);

	}

	public static void main(String[] args) {
		new StudentInfo();
	}

}
