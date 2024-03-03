package chapter18;

public class Ex03_Varargs {
    // 가변 인수 표시
    public static void helloEverybody(String ... vargs){
        // 배열과 같은 방식으로 가변 인수 사용
        for(String s : vargs)
            System.out.print(s + '\t');
        System.out.println();
    }

    public static void main(String[] args) {
        helloEverybody("홍길동");
        helloEverybody("홍길동","전우치");
        helloEverybody("홍길동","전우치","손오공");
    }
}
