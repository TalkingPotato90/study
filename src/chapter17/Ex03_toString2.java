package chapter17;

class Book3{
    String author;
}
public class Ex03_toString2 {
    public static void main(String[] args) {
        Book3 myBook = new Book3();
        myBook.author = "홍길동";
        // 참조 변수의 멤버 변수의 값 출력
        System.out.println(myBook.author);
        // 객체 자체 출력
        // toString이 재정의 되지 않고 상속받은대로
        // 클래스명@해시코드 로 출력됨
        System.out.println(myBook);
    }
}
