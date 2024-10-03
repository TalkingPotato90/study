package day0206;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter를 사용한 출력
 */
public class UseBufferedWriter {
    public UseBufferedWriter() {
        // 1. 파일 생성
        File file = new File("C:/dev/temp/java_write3.txt");

        // 2. 스트림 생성
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            String msg = "이것이 자바다. 신용권저";
            // 3. 스트림에 파일로 출력할 데이터를 기록
            bw.write(msg);
            // 4. 스트림에 남아있는 데이터를 목적지로 분출
            bw.flush();
            System.out.println("파일로 기록 완료");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UseBufferedWriter();
    }
}
