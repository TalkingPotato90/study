package day0205;

import javax.swing.*;
import java.io.File;

/**
 * 파일 삭제
 */
public class UseFile3 {
    public static void main(String[] args) {
//        // 1. 삭제할 파일명을 가진 File 객체를 생성
//        File file = new File("c:/dev/temp/java_read2.txt");
//        // 2. 삭제
//        System.out.println(file.delete());
        // 1. 이전 이름을 가진 File 객체 생성
        File file = new File("c:/dev/temp/java_read2.txt");
        // 2. 변경할 파일명을 저장한 객체 생성
        File file2 = new File("c:/dev/temp/ywc.txt");
        // 3. 변경
        file.renameTo(file2);


        String fileInfo = JOptionPane.showInputDialog("삭제할 파일의 경로를 포함한 파일명을 입력하세요");
        File selectFile = new File(fileInfo);
        if (!selectFile.exists()) {
            JOptionPane.showMessageDialog(null, selectFile + "은 존재하지 않습니다. 파일 경로나 파일명을 확인해주세요");
            return;
        }
        int flag = JOptionPane.showConfirmDialog(null, selectFile.getName() + "파일을 삭제하시겠습니까?");
        switch (flag) {
            case JOptionPane.OK_OPTION:
                selectFile.delete();
                JOptionPane.showMessageDialog(null, selectFile + "파일이 삭제되었습니다.");
        }
    }
}
