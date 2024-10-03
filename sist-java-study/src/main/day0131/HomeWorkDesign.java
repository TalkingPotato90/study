package day0131;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class HomeWorkDesign extends JFrame {


	private JButton  addButon, changeButon, deleteButon, endButon;
	private JRadioButton man, wman;
	private DefaultListModel<String> dlmData;
	private JTextField jtfName, jftCallNum;
	private DefaultComboBoxModel<String> age;
	private JList<String> jlData;
	private JComboBox<String> jcbAge;


	public HomeWorkDesign() {
		super("숙제");
		setLayout(null);



		//////////////////////////////J.C.B
		dlmData = new DefaultListModel<String>();
		jlData = new JList<String>(dlmData);
		JScrollPane jspJlData = new JScrollPane(jlData);

		jspJlData.setBorder(new TitledBorder("정보"));
		jspJlData.setSize(160,220);
		jspJlData.setLocation(250,50);
		add(jspJlData);
		////////////////////////////////////////////////////



		///////////////////////나이
		age = new DefaultComboBoxModel<String>();
		jcbAge = new JComboBox<String>( age );
		JLabel jlblAge = new JLabel("나 이");
		int cnt = 20;
		for (int i = 0; i < 21; i++) {
			age.addElement(String.valueOf(cnt));
			cnt++;
		}

		jcbAge.setSize(100,25);
		jcbAge.setLocation(100,120);

		jlblAge.setSize(50,25);
		jlblAge.setLocation(60,120);

		add(jcbAge);
		add(jlblAge);
		///////////////////////////////////////////

		//////////////////////버튼
		addButon = new JButton("추가");
		changeButon = new JButton("변경");
		deleteButon = new JButton("삭제");
		endButon = new JButton("종료");

		addButon.setSize(60,25);
		changeButon.setSize(60,25);
		deleteButon.setSize(60,25);
		endButon.setSize(60,25);

		addButon.setLocation(50, 300);
		changeButon.setLocation(130, 300);
		deleteButon.setLocation(210, 300);
		endButon.setLocation(290, 300);

		add(addButon);
		add(changeButon);
		add(deleteButon);
		add(endButon);
		/////////////////////////////////////////

		/////////////////라디오 버튼 (남,녀)
		man= new JRadioButton("남",true);
		wman = new JRadioButton("여");
		JLabel jlblGender= new JLabel("성 별");
		ButtonGroup bg = new ButtonGroup();

		man.setSize(40,20);
		wman.setSize(40,20);

		man.setLocation(110,152);
		wman.setLocation(150,152);

		jlblGender.setSize(50,25);
		jlblGender.setLocation(60,150);

		bg.add(man);
		bg.add(wman);
		System.out.println();
		add(man);
		add(wman);
		add(jlblGender);
		/////////////////////////////////////////

		///////////////////이름
		jtfName = new JTextField(11);
		JLabel jlblName = new JLabel("이 름");

		jtfName.setSize(100,25);
		jtfName.setLocation(100,80);

		jlblName.setSize(50,25);
		jlblName.setLocation(60,80);


		add(jtfName);
		add(jlblName);
		//////////////////////////////////////////

		//////////////전화번호
		jftCallNum = new JTextField(11);
		JLabel jlblCall = new JLabel("전화번호");

		jlblCall.setSize(50,25);
		jlblCall.setLocation(60,180);


		jftCallNum.setSize(100,25);
		jftCallNum.setLocation(120,180);


		add(jlblCall);
		add(jftCallNum);

		///////////////////////////////


		/////이벤트 등록//////
		HomeWorkEvent hwe = new HomeWorkEvent(this);
		addWindowListener(hwe);
		addButon.addActionListener(hwe);
		changeButon.addActionListener(hwe);
		deleteButon.addActionListener(hwe);
		endButon.addActionListener(hwe);
		man.addActionListener(hwe);
		wman.addActionListener(hwe);

		jlData.addMouseListener(hwe);


		///////////////////

		//
		setSize(450,400);
		setResizable(false);//크기 변경 막기
		setLocation(900, 200);
		setVisible(true);

		///////////////////////////

	}//생성자


	public JComboBox<String> getJcbAge() {
		return jcbAge;
	}


	public DefaultComboBoxModel<String> getAge() {
		return age;
	}


	public JButton getAddButon() {
		return addButon;
	}


	public JButton getChangeButon() {
		return changeButon;
	}


	public JButton getDeleteButon() {
		return deleteButon;
	}


	public JButton getEndButon() {
		return endButon;
	}


	public JRadioButton getMan() {
		return man;
	}


	public JRadioButton getWman() {
		return wman;
	}


	public DefaultListModel<String> getDlmData() {
		return dlmData;
	}


	public JTextField getJtfName() {
		return jtfName;
	}


	public JTextField getJftCallNum() {
		return jftCallNum;
	}


	public JList<String> getJlData() {
		return jlData;
	}






}//class
