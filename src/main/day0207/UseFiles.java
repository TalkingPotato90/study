package day0207;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class UseFiles {
	
	public void allLines() {
		
		// 1. 읽어 들일 파일의 경로를 설정.
		Path path = Paths.get("c:/dev/temp/java_read.txt");
		System.out.println(path);
		
		// 2. 파일의 내용을 읽는다.
		try {
			List<String> lines = Files.readAllLines(path);

			// 여러 번 로딩 시 for문 사용
//			for(String readLine : lines) {
//				System.out.println(readLine);
//			}	// end for
			
			// 한 번만 로딩 시 iterator 사용
			Iterator<String> ita = lines.iterator();
			while(ita.hasNext()) {
				System.out.println(ita.next());
			}	// end while

		} catch (NoSuchFileException nsfe) {
			System.err.println("경로를 확인하세요.");
			nsfe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	// end catch
		
	}	// allLines

	public static void main(String[] args) {
		new UseFiles().allLines();
	}	// main

}	// class