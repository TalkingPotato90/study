package day0206;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 8bit stream을 사용한 파일 출력
 */
public class UseFileOutputStream {

    public UseFileOutputStream() throws IOException {

        // 1. 파일 생성
        File file = new File("c:/dev/temp/java_write.txt");

        // 2. 스트림 생성 : 스트림이 생성되면 목적지에 파일이 존재하면 덮어쓰고, 없으면 생성한다.
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(file);

            int data = 65;
            // 3. 스트림에 파일로 보낼 내용 쓰기
//			fos.write(data);

            String str = "abcde가나다";
            byte[] b = str.getBytes();
            fos.write(b);

            // 4. 스트림에 기록된 내용을 목적지로 분출
            fos.flush();
        } finally {
            // 5. 스트림 사용이 끝났으면 연결을 끊어준다.
            if(fos != null) {
                fos.close();
            }	// end if
        }	// end finally

    }	// UseFileOutputStream

    public static void main(String[] args) {
        try {
            new UseFileOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }	// end catch
    }	// main

}	// class
