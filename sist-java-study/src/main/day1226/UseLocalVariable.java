package day1226;

//1. 지역변수 사용

class UseLocalVariable{

    int i; // instance variable

    // main method : 클래스를 단독으로 실행시켜야 할 때 정의하는 method
    // 단독으로 실행가능한 프로그램 : java application
    public static void main(String[] args){

        // 지역변수
        // 1. 선언 : 데이터형(자료형) 변수명;
        int maxScore = 100; // 초기화 값
        // int myScore; // 초기화 되지 않은 변수명
        int myScore = 0;

        System.out.println(myScore); // 초기화 되지 않은 변수를 사용하면 error 발생

        System.out.println("\n-----------------------------------------------------------\n");

        // 2. 값 할당 : 변수명 = 값;
        // maxScore = 100; // 1에서 선언과 동시에 초기화
        myScore = 80;

        // 3. 값 사용 : 출력

        System.out.print("최고 점수 " + maxScore + "점, 내 점수 " + myScore );
        System.out.println("최고 점수와의 차이 : " + (maxScore - myScore) + "점");

        // 4. 값 할당을 여러 번 할 수 있다
        myScore = 95;

        // 5. 재할당된 값 출력

        System.out.print("최고 점수 " + maxScore + "점, 내 점수 " + myScore );
        System.out.println("최고 점수와의 차이 : " + (maxScore - myScore) + "점");

        System.out.println("\n-----------------------------------------------------------\n");

        // 1. 올해를 저장할 수 있는 변수를 선언하고 초기값으로 올해를 할당
        // 2. 자신의 나이를 저장할 수 있는 변수를 선언하세요
        // 3. 2번의 변수에 자신의 나이를 할당하세요
        // 4. 두개의 변수를 사용하여 자신이 태어난 해를 연산하여 출력

        int thisYear = 2023;
        int myAge;

        myAge = 33;

        System.out.println("출생년도 : " + (thisYear - myAge));

        // int myScore = 10000; // 영역이 같으면 같은 이름의 변수는 하나만 선언 가능
        int i; // 영역이 다르므로 같은 이름의 변수를 선언 할 수 있다

    }//main

}//class

//2. 저장 : 클래스명.java (UseLocalVariable.java)

//3. 컴파일 : compiler 필요 ( javac.exe ) javac UseLocalVariable.java

//4. 실행 : 실행기 필요 ( java.exe ) java UseLocalVariable
