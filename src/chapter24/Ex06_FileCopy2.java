package chapter24;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Ex06_FileCopy2 {
    public static void main(String[] args) {
        String src = "./src/chapter24/Ex04_FileRead.java";
        String dst = "FileRead2.txt";

        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)){
            // 데이터를 담을 버퍼로 바이트 배열 생성
            byte[] buf = new byte[1024];
            int len;

            Instant start = Instant.now();

            while(true){
                // 버퍼 크기만큼 한 번에 읽기
                // 크기가 버퍼보다 작으면 그만큼만 읽기
                len = in.read(buf);
                if (len == -1)
                    break;
                out.write(buf,0,len);
            }

            Instant end = Instant.now();
            System.out.println("복사에 걸린 시간 : " + Duration.between(start, end).toMillis());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
