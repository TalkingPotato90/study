package day0202;

public class UseCompileException {
    public UseCompileException(){

        try {
            // 특정 클래스를 입력받아 객체로 저장하고 사용
//            Class cls = Class.forName("java.lang.String1");
            Class cls = Class.forName("day0202.UseRuntimeException2");
            System.out.println("로딩한 객체 : " + cls);
        }catch (ClassNotFoundException cnfe){
            System.err.println("앗! 클래스가 ㅇㅅㅇ");
            System.err.println(cnfe.getMessage());
            System.err.println(cnfe);
            cnfe.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new UseCompileException();
    }
}
