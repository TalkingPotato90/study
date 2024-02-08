package day0207;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Java의 기본형 데이터 형을 읽거나 쓰기 위해서 제공되는 Stream
 */
public class UseDataStream {
	
	public void writeData() throws IOException {
		int i = 2024;
		
		DataOutputStream dos = null;
		try {
			// 기본형 데이터형을 기록할 스트림을 파일에 연결
			dos = new DataOutputStream(new FileOutputStream("c:/dev/temp/data.txt"));
			// 스트림에 쓰기
//			dos.writeInt(i);
//			dos.writeDouble(2024.02);
			dos.writeUTF("오늘은 수요일 입니다.");
			// 분출
			dos.flush();
		} finally {
			if(dos != null) {
				dos.close();
			}	// end if
		}	// end finally
		
	}	// writeData
	
	public void readData() throws IOException {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("c:/dev/temp/data.txt"));
//			int readData = dis.readInt();
//			double readData = dis.readDouble();
			String readData = dis.readUTF();
			System.out.println(readData);
		} finally {
			if(dis != null) {
				dis.close();
			}	// end if
		}	// end finally
	}	// readData

	public static void main(String[] args) {
		UseDataStream uds = new UseDataStream();
		try {
			uds.writeData();
			System.out.println("쓰기 완료");
			uds.readData();
			System.out.println("읽기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class