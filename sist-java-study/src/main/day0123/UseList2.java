package day0123;

import java.util.*;

/**
 * ArrayList,Vector의 사용
 */
public class UseList2 {
    /**
     * 동기화 처리가 되어있지 않으므로 여러 객체가 동시에 접근 가능. Vector보다 속도 빠름
     */
    public void useArrayList() {
        // 1.생성
        List<String> list = new ArrayList<String>();

        // 2.값 할당)객체명.add(값); //방의 크기가 증가(가변길이형)
        list.add("Java");
        list.add("Oracle");
        list.add("JDBC");
        list.add("Java");// 중복 값 허용
        list.add("HTML");
        list.add("CSS");

        //2번째 방 위치(JDBC)에 "자바"를 추가(기존 요소 사이에 추가) =>효율이 떨어짐
        list.add(2, "자바");
        // 3.크기
        System.out.println(list.size() + "개");

        // 배열로 복사
        // 1.리스트의 크기대로 빈 배열을 생성
        String[] arr = new String[list.size()];
        // 2.복사
        list.toArray(arr);
        // 모든 방의 값 출력

//		for(int i = 0; i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
        for (String value : list) {
            System.out.println(value);
        }

        // 값 삭제 remove(인덱스), remove(요소의 값) 크기가 준다
//		list.remove(1);
        list.remove("Java");// 같은 값이 있다면 처음 값만 삭제
        list.clear();

        System.out.println(list + " / " + list.size());
        // 배열에 복사된 값을 출력
        for (String value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }// useArrayList

    /**
     * 동기화가 되기 때문에 여러 객체가 동시접근 불가. ArrayList보다 속도 느림.
     */
    public void useVector() {
        // 1.생성
        List<String> list = new Vector<String>();

        // 2.값 할당)객체명.add(값); //방의 크기가 증가(가변길이형)
        list.add("Java");
        list.add("Oracle");
        list.add("JDBC");
        list.add("Java");// 중복 값 허용
        list.add("HTML");
        list.add("CSS");

        // 3.크기
        System.out.println(list.size() + "개");

        // 배열로 복사
        // 1.리스트의 크기대로 빈 배열을 생성
        String[] arr = new String[list.size()];
        // 2.복사
        list.toArray(arr);
        // 모든 방의 값 출력

        for (String value : list) {
            System.out.println(value);
        }

        // 값 삭제 remove(인덱스), remove(요소의 값) 크기가 준다
//		list.remove(1);
        list.remove("Java");// 같은 값이 있다면 처음 값만 삭제
        list.clear();

        System.out.println(list + " / " + list.size());
        // 배열에 복사된 값을 출력
        for (String value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }// useVector

    public void useLinkedList() {
        // 1.생성
        List<String> list = new LinkedList<String>();

        // 2.값 할당)객체명.add(값); //방의 크기가 증가(가변길이형)
        list.add("Java");
        list.add("Oracle");
        list.add("JDBC");
        list.add("Java");// 중복 값 허용
        list.add("HTML");
        list.add("CSS");

        list.add(1,"자바"); // 기존 데이터 사이에 값을 추가

        // 3.크기
        System.out.println(list.size() + "개");

        // 배열로 복사
        // 1.리스트의 크기대로 빈 배열을 생성
        String[] arr = new String[list.size()];
        // 2.복사
        list.toArray(arr);
        // 모든 방의 값 출력

//        for (String value : list) {
//            System.out.println(value);
//        }

        System.out.println("Iterator를 사용한 출력");

        Iterator<String> ita = list.iterator();
        while (ita.hasNext()){
            System.out.println(ita.next());
        }

        // 값 삭제 remove(인덱스), remove(요소의 값) 크기가 준다
//		list.remove(1);
        list.remove("Java");// 같은 값이 있다면 처음 값만 삭제
        list.clear();

        System.out.println(list + " / " + list.size());
        // 배열에 복사된 값을 출력
        for (String value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }// useVector


    public static void main(String[] args) {
        UseList2 ul = new UseList2();
        System.out.println("------------ArrayList---------------");
        ul.useArrayList();
        System.out.println("------------UseVector---------------");
        ul.useVector();
        System.out.println("------------UseLinkedList---------------");
        ul.useLinkedList();

    }

}
