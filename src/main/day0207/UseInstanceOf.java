package day0207;

import java.io.NotSerializableException;
import java.io.Serializable;

/**
 * 객체가 특정 클래스로 부터 생성 된 것인지 비교 > casting
 */
public class UseInstanceOf {

    public void UseInstanceof(UserData ud) throws NotSerializableException {
        if(!(ud instanceof Serializable)) {
            //입력된 ud객체가 직렬화가 가능한 인터페이스를 구현한 클래스인가?
            //return;
            throw new NotSerializableException("직렬화부터 하고 오세요.");
        }//end if
        System.out.println(ud.toString());
    }//UseInstanceof

    public static void main(String[] args) {

        UserData ud = new UserData();

        UseInstanceOf ui = new UseInstanceOf();
        try {
            ui.UseInstanceof(ud);
        } catch (NotSerializableException e) {
            e.printStackTrace();
        }

    }//main

}//class