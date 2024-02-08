package day0207;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class FileCopy2 extends JFrame implements ActionListener {
	
	private JLabel jlOutput;
	
	public FileCopy2() {
		super("N-IO를 사용한 파일 복사");
		
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
	
	public void fileCopy() {
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
		
		// N-I/O를 사용한 파일 복사
		Path originPath = Path.of(fileOrigin.getAbsolutePath());	// JDK17부터 가능
//		Path originPath = Paths.get(fileOrigin.getAbsolutePath());	둘 중 하나 사용
		Path copyPath = Path.of(fileCopy.getAbsolutePath());
		
		try {
			Files.copy(originPath, copyPath, StandardCopyOption.REPLACE_EXISTING);
			jlOutput.setText(fileCopy.getName() + "으로 복사가 잘 되었습니다.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "파일 복사 도중 문제 발생");
			e.printStackTrace();
		}	// end catch
	}	// fileCopy
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		fileCopy();
	}	// actionPerformed

	public static void main(String[] args) {
		new FileCopy2();
	}	// main

}	// class