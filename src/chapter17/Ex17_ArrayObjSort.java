package chapter17;

import java.util.Arrays;

// Comparable 인터페이스
// 오름차순 순서상 크고 작음에 대한 기준 제공
class Person implements Comparable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 메서드 구현
    // 인터페이스의 compareTo 메서드를 구현
    public int compareTo(Object o) {
        Person p = (Person) o;

        // 이름을 비교하여 순서를 구함
        // 같은 값이면 0, 비교되는 대상이 크면 음수, 비교되는 대상이 작으면 양수
        int nNum = this.name.compareTo(p.name);
        return nNum;

//        if(this.age > p.age)
//            return 1;
//        else if(this.age < p.age)
//            return -1;
//        else
//            return 0;
    }

    // 객체를 출력할 때 멤버 변수를 이용하여 정보 출력
    public String toString() {
        return name + " : " + age;
    }
}

public class Ex17_ArrayObjSort {
    public static void main(String[] args) {
        Person[] arr = new Person[3];

        arr[0] = new Person("홍길동", 29);
        arr[1] = new Person("전우치", 15);
        arr[2] = new Person("손오공", 37);

        // Arrays 클래스의 메서드를 이용하여 배열 정렬
        Arrays.sort(arr);

        for (Person p : arr)
            System.out.println(p);
    }
}
