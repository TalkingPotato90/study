package day0206;

import java.io.*;

public class TestStream {
    public TestStream() throws IOException {
        // C:/dev/temp/java_write4.txt 파일을 생성한 후
        // C:/dev/temp/java_read.txt 를 읽어들여 java_write4.txt 쓰는
        // 코드를 작성해보세요

        // 단, C:/dev/temp/java_write4.txt 파일이 존재하지 않으면 파일을 생성하고.
        // 존재한다면 덮어 쓸 것인지 물어본 후 파일에 덮어 쓴다

        File readFile = new File("c:/dev/temp/java_read.txt");
        File file = new File("C:/dev/temp/java_write4.txt");

        if (file.exists()) {
            System.out.println(file.getName() + "를 덮어 쓰시겠습니까?");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(readFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            String lineData;
            while ((lineData = br.readLine()) != null) {
                bw.write(lineData);
                bw.newLine();
            }
            bw.flush();
        }
    }

    public static void main(String[] args) {
        try {
            new TestStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
