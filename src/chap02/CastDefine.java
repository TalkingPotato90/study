package chap02;

public class CastDefine {
    public static void main(String[] args) {
        /*
        i = (int)l l이 int형의 범위를 넘으면 오류,
        integer형의 범위가 넘는 값은 int로 Casting 안됨
        integer형의 범위는 -2147483648 ~ 2147483647
        */
        long l = 123456789;
        // long 형을 int형으로 명시적 형 변환
        int i = (int) l;
        System.out.println("-->묵시적 명시적 형변환<--");
        System.out.println("i --> " + i);

        /*
        작은데 큰것을 넣을 때는 명시적으로 형 변환 처리
        i = l; integer는 4바이트, long형은 8바이트이므로 에러
         */

        i = 65535;
        // int형을 byte형으로 형 변환 음수 출력
        byte b = (byte) i; // 65535가 -1로 바뀜
        System.out.println("b --> " + b);

        // 왼쪽이 작으므로 명시적 형 변환 필요, 협소화
        double d = 3.1313139313;
        // float형 변환해서 대입
        float f = (float) d;
        System.out.println("f --> " + f);

        // 왼쪽이 크므로 컴파일러에 의한 묵시적인 형 변환, 광역화
        f = i;
        System.out.println("i --> " + i);
        System.out.println();
    }
}
