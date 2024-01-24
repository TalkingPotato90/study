package day0124;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 키와 값의 쌍으로 이루어진 데이터형
 */
public class UseMap {
    /**
     * 기본생성자를 사용하여 생성하면 11개의 행이 생성되는 HashTable의 사용
     * 속도 느림
     */
    public void useHashTable() {
        // 1. Map 생성
        Map<String, String> map = new Hashtable<String, String>();
        // 2. Map 값 설정 : map.put(키, 값) - 순서대로 입력되지 않는다
        map.put("A", "세심하다, 친절하다. ^o^b");
        map.put("B", "성질드럽다. ㅡ,.ㅡ");
        map.put("AB", "싸이코 @.@");
        map.put("O", "우유부단 ~(^^~)(~^^)~");
        // 키가 중복되면 같은 키에 덮어 쓴다.
        map.put("A", "소심하다 ☞(^-^)☜");
        // 키가 다르면 중복 값을 허용
        map.put("a", "소심하다 ☞(^-^)☜");

        // 검색 : 키를 사용하여 값을 검색 map.get(키)
        String key = "b";
        // 맵에 키가 존재하는지?
        if (map.containsKey(key)) {
            String value = map.get(key); // 키가 존재하지 않으면 null이 반환
            System.out.println(key + "의 특징은 " + value);
        } else {
            System.out.println(key + "에 대한 값은 준비되어 있지 않습니다.");
        }

        // 값 삭제
        map.remove("a");
        map.clear();

        System.out.println(map.isEmpty());

        System.out.println(map);

    }


    /**
     * 기본생성자를 사용하여 생성하면 16개의 행이 생성되는 HashMap의 사용
     * 속도 빠름
     */
    public void useHashMap() {
        // 1. Map 생성
        Map<String, String> map = new HashMap<String, String>();
        // 2. Map 값 설정 : map.put(키, 값) - 순서대로 입력되지 않는다
        map.put("A", "세심하다, 친절하다. ^o^b");
        map.put("B", "성질드럽다. ㅡ,.ㅡ");
        map.put("AB", "싸이코 @.@");
        map.put("O", "우유부단 ~(^^~)(~^^)~");
        // 키가 중복되면 같은 키에 덮어 쓴다.
        map.put("A", "소심하다 ☞(^-^)☜");
        // 키가 다르면 중복 값을 허용
        map.put("a", "소심하다 ☞(^-^)☜");

        // 검색 : 키를 사용하여 값을 검색 map.get(키)
        String key = "b";
        // 맵에 키가 존재하는지?
        if (map.containsKey(key)) {
            String value = map.get(key); // 키가 존재하지 않으면 null이 반환
            System.out.println(key + "의 특징은 " + value);
        } else {
            System.out.println(key + "에 대한 값은 준비되어 있지 않습니다.");
        }

        // 값 삭제
        map.remove("a");
        map.clear();

        System.out.println(map.isEmpty());

        System.out.println(map);

    }

    public static void main(String[] args) {
        UseMap um = new UseMap();
        System.out.println("----------------HashTable-------------");
        um.useHashTable();
        System.out.println("----------------HashMap-------------");
        um.useHashMap();
    }
}
