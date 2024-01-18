package day1226;

//1. 표준 출력 스트림 사용

class UseConsoleOutput {
    public static void main(String[] args) {
		/*
		System.out.print("안녕");
        System.out.print("하세요?");
        System.out.println("안녕");
        System.out.println("하세요?");
		*/
        // 상수
        System.out.println(2023); // 정수상수 - 정수 2023
        System.out.println(12.26); // 실수상수
        System.out.println('0'); // 문자상수 - 문자의 0
        System.out.println(true); // 불린(boolean) 상수
        System.out.println("오늘은 화요일입니다."); // 문자열상수

        // 변수
        int i = 26;
        System.out.println(i);

        // 연산식 : 연산의 결과만 출력
        System.out.println(12 + 26);
        System.out.println("12 + 26 = " + (12 + 26));
    }
}

//2. 저장 : 클래스명.java (UseConsoleOutput.java)

//3. 컴파일 : compiler 필요 ( javac.exe ) javac UseConsoleOutput.java

//4. 실행 : 실행기 필요 ( java.exe ) java UseConsoleOutput
