package chapter24;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_FileWrite1 {
    public static void main(String[] args) throws IOException {
        // 파일을 생성하고 해당 파일에 스트림 생성
        OutputStream out = new FileOutputStream("data.txt");
        // 스트림을 통해 데이터 전송
        out.write(65); // ASCII 코드 65 = 'A'
        // 파일 종료
        out.close();
    }
}
