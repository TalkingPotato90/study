package day0119;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 입력된 형식으로 날짜를 만들어 제공하는 클래스
 */
public class UseSimpleDateFormat {
    public UseSimpleDateFormat() {
        // 1. 객체생성
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH(kk,KK,hh):mm:ss EEEE", Locale.KOREA);
        // 2. method 호출
        System.out.println(sdf.format(new Date()));
    }

    public static void main(String[] args) {
        new UseSimpleDateFormat();
    }
}
