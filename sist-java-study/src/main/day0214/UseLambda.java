package day0214;

import java.util.Calendar;

public class UseLambda {

	public static void main(String[] args) {
		
		// Lambda식을 사용하면 class 파일을 생성하지 않고 인터페이스를 쉽게 사용할 수 있다.
		
		// 반환형 없고 매개변수 없는 형
		Test t = () -> { 
			int day = 14;	// method 안처럼 코드 작성 
			System.out.println("반환형 없고 매개변수 없는 형");
			System.out.println(day + "일");
		};
			
		t.temp();
		System.out.println("-----------------------------------------");
			
		// 반환형 없고 매개변수 있는 형
		Test2 t2 = (int age, String name) -> {
			int nowYear = Calendar.getInstance().get(Calendar.YEAR);
			System.out.println("반환형 없고 매개변수 있는 형");
			System.out.println(name + "님 나이: " + age + "살, " + (nowYear-age) + "년생");
		};
		
		t2.temp(20, "콜라");
		System.out.println("-----------------------------------------");

		// 반환형 있고 매개변수 없는 형
		Test3 t3 = () -> {
			String name = "콜라 친구 사이다";
			return name;
		};
		
		System.out.println("반환형 있고 매개변수 없는 형");
		String name = t3.temp();
		System.out.println(name);
		System.out.println("-----------------------------------------");

		// 반환형 있고 매개변수 있는 형
		Test4 t4 = (String name2, int age) -> {
			String grade = "평민";
			if(name2.equals("콜라")) {
				grade = "반장";
			}	// end if
			return grade + " " + name2 + "님 나이는 " + age + "살";
		};
		
		System.out.println("반환형 있고 매개변수 있는 형");
		String result = t4.temp("콜라", 20);
		String result2 = t4.temp(t3.temp(), 25);
		System.out.println(result + "\n" + result2);
		System.out.println("-----------------------------------------");
		
		// 1~10까지 Thread를 사용하여 출력하는 코드를 람다식으로 작성
		Runnable r = () -> {
			// Thread로 동작해야 하는 코드 정의
			for(int i = 1; i < 11; i++) {
				System.out.println("run -----------> " + i);
			}	// end for
		};
		
		Thread th = new Thread(r);	// has a
		th.start();
		for(int i = 1; i < 11; i++) {
			System.out.println("main for =====================> " + i);
		}	// end for
		
		
	}	// main

}	// class