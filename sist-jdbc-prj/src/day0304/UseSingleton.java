package day0304;

public class UseSingleton {

	public static void main(String[] args) {
//		Singleton single = new UseSingleton();
		Singleton single1 = Singleton.getIstance();
		Singleton single2 = Singleton.getIstance();
		Singleton single3 = Singleton.getIstance();
		//객체는 다르지만 모두 동일한 주소가 나오게된다.
		System.out.println(single1);
		System.out.println(single2);
		System.out.println(single3);
		
	}

}
