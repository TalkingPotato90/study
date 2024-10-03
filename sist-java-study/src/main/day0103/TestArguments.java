package day0103;

/**
 * main method의 arguments 입력과 사용에 대한 연습.<br>
 * <p>
 * 실행) java day010..TestArguments 값 값 값 ... 값
 */
public class TestArguments {

    public static void main(String[] args) {

        System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        //문자열(String)은 연산되지 않는다 (붙임)
        System.out.println(args[0] + args[1]);

        //int i = args[0]; // 참조형을 기본형에 할당할 수 없다.
        //int i = (int)args[0]; // 문자열을 기본형으로 간에형변환 할 수 없다.
        //문자열을 정수로 변환하는 일(method)을 하는 method를 사용
        int num = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        System.out.println(num + " + " + num2 + " = " + (num + num2));

    }

}
