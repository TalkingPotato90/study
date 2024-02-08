package day0208;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestURLEncoder {

	public static void main(String[] args) {
		// TCP Protocol을 사용하면 영어, 숫자, 특수문자인 1byte charset에 대해서는 packet의 segment에 실려 전송되지만,
		// 한글 2~3byte인 charset에 대해서는 segment에 실을 수가 없다.
		// 이 것을 해결하기 위해서 2~3byte의 한글을 1byte씩 분할해서 encoding 한 후 전달하게된다.
		// 예) UTF-8을 사용하는 한글 "가"인 경우에는 =>  3byte의 코드값으로 encoding된다. %AB%BC%D1
		
		String str = "즐거운";
		System.out.println("원본: " + str);
		try {
			// 3byte의 한글을 Network로 보내기 위해서 
			String encode = URLEncoder.encode(str, "UTF-8");
			System.out.println("인코딩: " + encode);
			
			// 알아볼 수 없는 encode된 한글을 알아볼 수 있게 재조합.
			String decode = URLDecoder.decode(str, "UTF-8");
			System.out.println("디코딩: " + decode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	// end catch
	}	// main

}	// class