package day0202;

public class UseRuntimeException {
    public static void main(String[] args) {

        // main method의 arguments를 두개 입력받아 나눈 연산을 수행한 후
        // 결과를 보여주는 일

        int num = 0;
        int num2 = 0;
        int result = 0;

        try {
            num = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);
            result = num / num2;

            System.out.println(num + " / " + num2 + " = " + result);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println("실행법) java UseRuntimeException 값 값");
            System.err.println("간단한 메시지 : " + aioobe.getMessage());
            System.err.println("예외클래스와 메시지 : " + aioobe);
            aioobe.printStackTrace();
        } catch (NumberFormatException nfe) {
            System.err.println("값은 숫자이어야 합니다");
            System.err.println("간단한 메시지 : " + nfe.getMessage());
            System.err.println("예외클래스와 메시지 : " + nfe);
            nfe.printStackTrace();
        } catch (ArithmeticException ae) {
            System.err.println("0으로 나눌 수 없습니다");
            System.err.println("간단한 메시지 : " + ae.getMessage());
            System.err.println("예외클래스와 메시지 : " + ae);
            ae.printStackTrace();
        } catch (Exception e){ // 부모는 모든 예외를 잡아 줄 수 있다
            e.printStackTrace();
        }finally {
            System.out.println("반드시 실행될 코드 정의");
        }
    }
}
