package day0207;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UseObjectStream {

    public void writeObject(UserData ud)
            throws NotSerializableException, IOException {
        //1. 스트림 생성
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("e:/E/dev/temp/obj.txt"));
            //2. 입력받은 객체 쓰기
            oos.writeObject(ud);
            //직렬화가 되지 않은 객체라면 NotSerializableException이 throws된다.
            //3. 분출
            oos.flush();
        }finally {
            //4. 끊기
            if(oos != null) { oos.close(); } //end if
        } //end finally
    }//writeObject

    public UserData readObject() throws IOException, ClassNotFoundException {
        UserData ud = null;
        //1. 객체를 읽어 들일 수 있는 스트림을 생성
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("e:/E/dev/temp/obj.txt"));
            //2. 객체를 읽어 들인다.
            ud = (UserData)ois.readObject();
        }finally {
            if(ois != null) { ois.close(); } //end if
        }//end finally

        return ud;

    }//readObjact


    public static void main(String[] args) {
        UseObjectStream uos = new UseObjectStream();

        //쓰기
//		UserData ud = new UserData("윤웅찬",182.5,67.8);
//		try {
//			uos.writeObject(ud);
//			System.out.println("객체 쓰기 완료");
//		} catch (NotSerializableException e) {
//			System.err.println("객체 직렬화가 되지 않는 클래스. 스트림을 타고 JVM 밖으로 나갈 수 없다.");
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}//end catch

        //읽기
        try {
            UserData ud = uos.readObject();
            System.out.println(ud.getName() + "님의 키 : " + ud.getHeight()
                    + " ,몸무게 : " + ud.getWeight());
        } catch (ClassNotFoundException cnfe) {
            System.err.println("파일에 객체가 없습니다.");
            cnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main

}//class