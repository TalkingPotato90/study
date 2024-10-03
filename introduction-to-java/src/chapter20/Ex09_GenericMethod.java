package chapter20;

class MyData {
    public static <T> T showData(T data) {
        // 입력되는 값의 데이터형에 따라 Generic을 정한다
        if (data instanceof String)
            System.out.println("String");
        else if (data instanceof Integer)
            System.out.println("Integer");
        else if (data instanceof Double)
            System.out.println("Double");
        return data;
    }
}

public class Ex09_GenericMethod {
    public static void main(String[] args) {
        MyData.<String>showData("Hello World");
        MyData.showData(1); // <Integer> 생략
        MyData.showData(1.0); // <Double> 생략
    }
}
