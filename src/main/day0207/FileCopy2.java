package day0207;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@SuppressWarnings("serial")
public class FileCopy2 extends JFrame implements ActionListener {

    private JLabel JlOutput;

    public FileCopy2() {
        super("NIO를 사용한 파일 복사");

        JButton jbtnCopy = new JButton("복사할 파일 선택");
        JlOutput = new JLabel("복사할 파일을 선택해 주세요");
        JPanel jpCenter = new JPanel();
        jpCenter.add(jbtnCopy);
        JlOutput.setBorder(new TitledBorder("출력"));

        add("Center", jpCenter);
        add("South", JlOutput);

        jbtnCopy.addActionListener(this);

        setBounds(100, 100, 300, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }// FileCopy

    public void fileCopy() {
        // 원본 파일명 얻기
        FileDialog fdOpen = new FileDialog(this, "복사할 파일 선택", FileDialog.LOAD);
        fdOpen.setVisible(true);

        if (fdOpen.getDirectory() == null) {
            return;
        }

        File fileOrigin = new File(fdOpen.getDirectory() + fdOpen.getFile());

        if (!fileOrigin.exists()) {
            JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다");
            return;
        }

        // 복사할 파일 명을 생성:원본파일명 +_bak.확장자 -> a.txt =>a_bak.txt
        StringBuilder tempFileName = new StringBuilder(fileOrigin.getAbsolutePath());
        tempFileName.insert(tempFileName.lastIndexOf("."), "_bak");

        File fileCopy = new File(tempFileName.toString());
        // N-I/O를 사용한 파일 복사
        Path originPath = Path.of(fileOrigin.getAbsolutePath());
        Path copyPath = Path.of(fileCopy.getAbsolutePath());

        try {
            Files.copy(originPath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            JlOutput.setText(fileCopy.getName() + "파일명으로 복사가 되었습니다.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일 복사도중 문제 발생");
            e.printStackTrace();
        }
    }// fileCopy

    @Override
    public void actionPerformed(ActionEvent e) {
        fileCopy();
    }// actionPerformed

    public static void main(String[] args) {
        FileCopy2 fc = new FileCopy2();
        fc.fileCopy();
    }
}// class