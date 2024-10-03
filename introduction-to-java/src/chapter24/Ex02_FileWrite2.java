package chapter24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex02_FileWrite2 {
    public static void main(String[] args) {
        // 지역변수의 범위가 달라지므로 바깥에 변수 선언
        OutputStream out = null;
        try {
            out = new FileOutputStream("data.txt");
            out.write(65); // ASCII 코드 65 = 'A'
            // 에러가 발생하더라도 close() 메서드를 확실하게 부르고 종료하기 위해
            // finally 구문으로 이동
            // out.close();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                try {
                    // 여기서도 예외가 발생할 수 있어 try~catch 또 써야 함
                    out.close();
                } catch (IOException e2) {
                }

            }
        }
    }
}
