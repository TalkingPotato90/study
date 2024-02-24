package chapter09;

class Book{
    String title;
    int price;
    int num = 0;

    // 디폴트 생성자에 기능 부여
    // 자동으로 생기는 생성자에는 아무런 기능이 없으므로 직접 만들고 코드처럼 객체가 생성될 때 변수에 값을 대입하여 초기화
    Book(){
        title = "자바 프로그래밍";
        price = 30000;
    }

    // 생성자의 오버로딩
    // 생성자를 오버로딩해서 매개변수가 있는 생성자 생성
    Book(String t, int p){
        // 매개변수로 값을 받아 멤버 변수의 값을 초기화
        title = t;
        price = p;
    }

    // 멤버 변수의 값을 출력
    void print(){
        System.out.println("제   목 : " + title);
        System.out.println("가   격 : " + price);
        System.out.println("주문수량 : " + num);
        System.out.println("합계급액 : " + price * num);
    }
}
public class ConstructorUse {
    public static void main(String[] args) {
        // 디폴트 생성자 사용
        // 디폴트 생성자와 new 연산자를 이용하여 객체 생성
        Book book1 = new Book();
        book1.print();

        // 오버로딩된 생성자 사용
        // 오버로딩된 생성자와 new 연산자를 이용하여 객체 생성
        // 생성자의 매개변수로 값을 넘겨 생성되는 객체의 멤버 변수의 값을 초기화
        Book book2 = new Book("자바 디자인 패턴", 35000);
        // 객체의 멤버 변수에 직접 값을 대입
        book2.num = 10;
        // 객체의 메서드 호출
        book2.print();
    }
}
