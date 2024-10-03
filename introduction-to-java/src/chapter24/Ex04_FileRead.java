package chapter24;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ex04_FileRead {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream("data.txt"))
        {
            // 데이터 1바이트 읽기
            int dat = in.read();
            // 읽은 데이터 출력 : 10진수
            System.out.println(dat);
            // 문자포맷 지정 출력 : A
            System.out.printf("%c \n", dat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
