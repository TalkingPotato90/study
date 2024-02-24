package chap04;

public class ObjectCreate {
    public void MethodCall() {
        System.out.println("MethodCall 메소드가 호출되었습니다!!!");
        System.out.println();
    }
}

class ObjectInit{
    public static void main(String[] args) {
        ObjectCreate OC1= new ObjectCreate();
        System.out.println("-->객체의 생성 실습<--\n");
        System.out.println("OC1 객체를 생성했습니다!!!");
        System.out.println("OC1의 MethodCall 메소드를 호출했습니다!!!");
        OC1.MethodCall();
        System.out.println("ObjectInit 프로그램이 종료됩니다!!!");
        System.out.println();
    }
}
