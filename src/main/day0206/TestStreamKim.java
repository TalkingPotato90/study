package day0206;

import javax.swing.*;
import java.io.*;

/**
 * C:/dev/temp/java_write4.txt 파일을 생성한 후
 * C:/dev/temp/java_read.txt를 읽어들여 C:/dev/temp/java_write4.txt에 쓰는 코드 작성
 * <p>
 * 단, C:/dev/temp/java_write4.txt 파일이 존재하지 않으면 파일을 생성하고,
 * 존재한다면, 덮어쓸 것인지 물어본 후 파일에 덮어쓴다
 */
public class TestStreamKim {

    public TestStreamKim() throws IOException {
        File newFile = new File("C:/dev/temp/java_write4.txt");
        if (newFile.exists()) {
            switch (JOptionPane.showConfirmDialog(null, newFile.getAbsolutePath() + "이 존재합니다.\n덮어쓰시겠습니까?")) {
                case JOptionPane.NO_OPTION:
                case JOptionPane.CANCEL_OPTION:
                    return;
            } // end switch
        } // end if

//		StringBuilder sb = new StringBuilder();
//		File prevFile = new File("C:/dev/temp/java_read.txt");
//		try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(prevFile)))) {
//			String str = "";
//			while( (str = bf.readLine()) != null) {
//				sb.append(str).append("\n");
//			} // end while
//		} catch (IOException ie) {
//			ie.printStackTrace();
//		} // end catch
//
//		try(BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
//			bw.write(sb.toString());
//		} catch (IOException ie) {
//			ie.printStackTrace();
//		} // end catch

        BufferedReader br = null;
        BufferedWriter bw = null;
        File readFile = new File("C:/dev/temp/java_read.txt");
        try {
            br = new BufferedReader(new FileReader(readFile));
            bw = new BufferedWriter(new FileWriter(newFile));

            String lineData;
            while ((lineData = br.readLine()) != null) {
                bw.write(lineData + "\n");
            }
            bw.flush();
        } finally {
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.close();
            }
        }

    } // TestStream

    public static void main(String[] args) {
        try {
            new TestStreamKim();
        } catch (IOException e) {
            e.printStackTrace();
        }

    } // main

} // class
