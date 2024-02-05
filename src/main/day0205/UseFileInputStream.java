package day0205;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class UseFileInputStream {
    public UseFileInputStream() throws IOException {
        // 1.파일 생성
        File file = new File("C:/dev/temp/java_Read.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "파일 명이나 경로를 확인해 주세요");
            return;

        } // end if
        // 2.파일을 읽기 위한 Stream을 연결
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            int readData = 0;
            while ((readData = fis.read()) != -1) {// 1byte읽어들여 값이 존재하면
                System.out.println((char) readData);// 값을 출력한다.
            }
        } finally {
            if (fis != null) {
                fis.close();
            }//end

        } // end finally
    }// UseFileInputStream

    public static void main(String[] args) {

//		try {
//			new UseFileInputStream();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
        JTextArea jta = new JTextArea(10, 50);
        JScrollPane jsp = new JScrollPane(jta);
        jta.setText("포항항 ^O^");
        jta.setEditable(false); //문장 수정 불가
        JOptionPane.showMessageDialog(null, jsp);

    }// main

}// class
