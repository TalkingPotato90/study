package day0207;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FileCopy3 extends JFrame implements ActionListener {
	
	private JLabel jlOutput;
	
	public FileCopy3() {
		super("파일 복사");
		
		JButton jbtnCopy = new JButton("복사할 파일 선택");
		jlOutput = new JLabel("복사할 파일을 선택해주세요.");
		JPanel jpCenter = new JPanel();
		jpCenter.add(jbtnCopy);
		
		jlOutput.setBorder(new TitledBorder("출력"));
		
		add("Center", jpCenter);
		add("South", jlOutput);
		
		jbtnCopy.addActionListener(this);
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	// FileCopy
	
	public void fileCopy() throws IOException {
		// 원본파일명 얻기
		FileDialog fdOpen = new FileDialog(this, "복사할 파일 선택", FileDialog.LOAD);
		fdOpen.setVisible(true);

		if(fdOpen.getDirectory() == null) {
			return;
		}	// end if
		
		File fileOrigin = new File(fdOpen.getDirectory() + fdOpen.getFile());
		
		if(!fileOrigin.exists()) {
			JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
			return;
		}	// end if
		
		// 복사할 파일명을 생성 : 원본파일명_bak.확장자 => a.txt => a_bak.txt
		StringBuilder tempFileName = new StringBuilder(fileOrigin.getAbsolutePath());
		tempFileName.insert(tempFileName.lastIndexOf("."), "_bak");
		
		File fileCopy = new File(tempFileName.toString());
		
		// 16bit스트림 연결
		// 읽기 가능 - 단순 txt, HTML, XML, json, java .... , 불가능 : 그외
		// 읽기
		BufferedReader br = null;
		// 쓰기
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader(fileOrigin));
			bw = new BufferedWriter(new FileWriter(fileCopy));
			
			String temp = "";
			// 줄단위로 읽어들여 (\n 전까지 읽어들인다.)
			while((temp = br.readLine()) != null) {
				// 읽어 들인 내용을 스트림에 기록
				bw.write(temp);
			}	// end while
			// 스트림에 존재하는 내용을 목적지로 분출
			bw.flush();
			jlOutput.setText(fileCopy.getName() + "으로 복사가 잘 되었습니다.");
		} finally {
			// 연결을 끊는다.
			if(br != null) {
				br.close();
			}	// end if
			if(bw != null) {
				bw.close();
			}	// end if
		}	// end finally
	}	// fileCopy
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			fileCopy();
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "파일 복사 중 문제가 발생했습니다.");
			e1.printStackTrace();
		}	// end catch
	}	// actionPerformed

	public static void main(String[] args) {
		new FileCopy3();
	}	// main

}	// class