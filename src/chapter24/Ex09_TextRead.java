package chapter24;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex09_TextRead {
    public static void main(String[] args) {
        try (Reader in = new FileReader("text.txt")) {
            int ch;
            while (true) {
                // 문자를 스트림으로부터 하나 읽어 int형 변수에 대입
                // 2바이트인 char형을 4바이트인 int에 저장하는 이유
                // -> 데이터를 더 이상 읽을 수 없을 때 -1을 반환받기 위해
                // -> -1은 char형 데이터 범위에 없는 값
                ch = in.read();
                if (ch == -1)
                    break;
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
