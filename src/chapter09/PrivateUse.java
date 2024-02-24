package chapter09;

// 접근 제한자를 지정하지 않아서 default
// 같은 패키지 안의 클래스에서 언제든지 변수에 접근하여 사용 가능
class Student1{
    String name;
    int age;
}

// name 변수는 public, age 변수는 private
class Student2{
    public String name;
    // private 멤버 변수
    // 다른 클래스에서 접근 불가
    private int age;

    public  Student2(String name, int age){
        this.name = name;
        this.age = age;
    }

    // 게터
    // private 변수의 값을 다른 클래스에서 가져갈 수 있게 제공
    public int getAge(){
        return age;
    }

    // 세터
    // private 변수의 값을 다른 클래스에서 대입할 수 있게 제공
    public void setAge(int age){
        // 유효성 검사
        // 부적절한 나이를 대입하지 못하게 체크
        if (age < 0 || age > 150){
            System.out.println("나이가 부적절합니다.");
            this.age = 0;
            return;
        }
        this.age = age;
    }
}
public class PrivateUse {
    public static void main(String[] args) {
        // default 상태라 접근 가능
        Student1 student1 = new Student1();
        // 멤버 변수에 직접 전근
        student1.name = "홍길동";
        // 멤버 변수에 직접 접근
        // 부적절한 값이 대입될 수 있다 (논리적으로 부적절)
        // 컴파일 에러는 발생 ❌ (자료형에 맞는 값이므로)
        student1.age = -20;
        System.out.printf("%s의 나이는 %d살입니다.\n", student1.name, student1.age);

        Student2 student2 = new Student2("전우치", 20);
        // public 멤버 변수에 직접 접근
        student2.name = "손오공";
        // private 멤버 변수에 직접 접근 시 에러발생
        // student2.age = -10;
        // 세터를 사용한 접근 ➡ 부적절한 값이라 유효성 검사에서 걸림
        // 메시지를 출력하고 0으로 강제 대입
        student2.setAge(-10);
        int age = student2.getAge();
        // 부적절한 값 입력시 0 출력
        System.out.printf("%s의 나이는 %d살입니다.\n", student2.name, age);
    }
}
