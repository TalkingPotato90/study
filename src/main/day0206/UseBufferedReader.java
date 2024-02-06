package day0206;

import java.io.*;

public class UseBufferedReader {
    public UseBufferedReader() throws FileNotFoundException, IOException {
        // 1. File 생성
        File readFile = new File("c:/dev/temp/java_read.txt");
        if (!readFile.exists()) {
            System.out.println(readFile.getAbsolutePath() + "는 존재하지 않습니다.");
            return;
        }
        // 2. 스트림 생성
//        FileInputStream fis = new FileInputStream(readFile); // 파일과 연결
//        // 8bit stream + 16bit stream 연결
//        InputStreamReader isr = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(isr); // 연결된 파일에서 줄단위로 읽어들이는

        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(readFile)));

            //3. 스트림에 연결된 파일의 내용 읽기
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static void main(String[] args) {
        try {
            new UseBufferedReader();
        } catch (FileNotFoundException e) {
            System.err.println("파일 경로를 확인해보세요");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("파일을 읽어들이는 동안 문제가 발생하였습니다.");
            e.printStackTrace();
        }
    }
}
