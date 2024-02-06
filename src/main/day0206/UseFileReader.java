package day0206;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 16 bit stream을 사용한 텍스트 파일의 내용 읽기
 */
public class UseFileReader {

    public UseFileReader() throws IOException {
        // 1. File 생성
        File readFile = new File("c:/dev/temp/java_read.txt");
        if (!readFile.exists()) {
            System.out.println(readFile.getAbsolutePath() + "는 존재하지 않습니다.");
            return;
        }

        // 2. stream 생성
//        FileReader fr + new FileReader(readFile); // 파일과 연결
//        BufferedReader br = new BufferedReader(fr);// 줄 단위로 읽기 위한 일

        BufferedReader br = null;
        try {
        br = new BufferedReader(new FileReader(readFile));

        // 3. stream에 연결되어 있는 파일을 읽어들인다.
        String str = "";
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }
        }finally {
            if (br != null){br.close();}
        }
    }

    public static void main(String[] args) {
        try {
            new UseFileReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
