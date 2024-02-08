package day0207;

import java.io.NotSerializableException;
import java.io.Serializable;

/**
 * 객체가 특정 클래스로부터 생성된 것인지 비교 > casting
 */
public class UseInstanceof {
	
	public void useInstanceof(UserData ud) throws NotSerializableException {
		if(!(ud instanceof Serializable)) {	// 또는 ud instanceof UserData
			// 입력된 ud객체가 직렬화가 가능한 인터페이스를 구현한 클래스인가?
//			return;
			throw new NotSerializableException("직렬화부터 하고 오세요.");
		}	// end if
		System.out.println(ud.toString());
	}	// useInstanceof

	public static void main(String[] args) {
		UserData ud = new UserData();
		UseInstanceof ui = new UseInstanceof();
		try {
			ui.useInstanceof(ud);
		} catch (NotSerializableException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class