package chapter24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_FileWrite3 {
    public static void main(String[] args) {
        // 리소스를 열어서 스트림을 생성하면 따로 닫아주지 않아도
        // 자바에서 자동으로 처리
        try(OutputStream out = new FileOutputStream("data.txt")){
            out.write(65); // ASCII 코드 65 = 'A'
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
