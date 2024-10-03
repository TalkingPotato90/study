package chapter24;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Ex05_FileCopy1 {
    public static void main(String[] args) {
        String src = "./src/chapter24/Ex04_FileRead.java";
        String dst = "FileRead1.txt";

        // 리소스 여러 개를 한꺼번에 지정 가능
        try(InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dst)){
            // 복사에 걸리는 시간을 측정
            // 시작 시각
            Instant start = Instant.now();

            int data;
            while (true){
                data = in.read();
                // 더 이상 읽을 데이터가 없으면 -1 반환
                if(data == -1)
                    break;
                out.write(data);
            }
            // 종료 시각
            Instant end = Instant.now();
            System.out.println("복사에 걸린 시간 : " + Duration.between(start, end).toMillis());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
