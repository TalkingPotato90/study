package chapter24;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex08_TextWrite {
    public static void main(String[] args) {
        try(Writer out = new FileWriter("text.txt")){
            for (int ch =(int)'A';ch< (int)('Z'+1); ch++)
                out.write(ch);
            // 캐리지 리턴 값의 저장 "\r" : 현재 위치를 나타내는 커서를 맨 앞으로 이동
            out.write(13);
            // 라인 피드 값의 저장 : 커서의 위치를 아랫줄로 이둥
            // 캐리지 리턴과 라인피트를 합쳐서 엔터 구현
            out.write(10);

            for (int ch =(int)'A'+32;ch< (int)('Z'+1+32); ch++)
                out.write(ch);
            out.write(13);
            out.write(10);

            out.write("동해물과 백두산이 마르고 닳도록");
            out.write("\r\n");
            out.write("하느님이 보우하사 우리나라 만세");
            out.write("\r\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
