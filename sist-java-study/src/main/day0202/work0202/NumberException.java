package day0202.work0202;

public class NumberException extends Exception{
    public NumberException(){
        super("2 ~ 9사이의 숫자만 입력 가능합니다");
    }
}
