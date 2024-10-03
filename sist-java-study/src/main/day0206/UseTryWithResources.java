package day0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseTryWithResources {
    public static void main(String[] args) {

        // 키보드의 입력값을 줄단위로 읽기
        // 개발자가 close 하지 않아도 JVM 에서 close ()해준다.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("아무키나 누르고 엔터.");
            String ReadData = br.readLine();
            System.out.println("입력 값: " + ReadData);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
        //try~ with ~resouces는 static인 stream(in,out,err)을 사용하지 않는다.
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("아무키나 누르고 엔터2");
            String ReadData = br.readLine();
            System.out.println("입력 값: " + ReadData);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }// main
}// class