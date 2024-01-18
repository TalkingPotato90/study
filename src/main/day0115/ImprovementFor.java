package day0115;

/**
 * 개선된 for<br>
 * - 배열, Collection의 처음 방부터 끝 방까지 순차적으로 출력해야 할 때<br>
 * 문법 :<br>
 * for (방의 값을 저장할 변수의 선언 : 대상){<br>
 * 변수명<br>
 * }<br>
 */
public class ImprovementFor {
    public static void main(String[] args) {
        int[] arr = {2024, 1, 15, 12, 19};

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        // 향상된 for loop
        for(int value : arr){
            System.out.println(value);
        }

        String[] arr2 ={"루피","쵸파","나미","샹크스","조로","샹디","우솝"};
        for (String name : arr2){
            System.out.println(name);
        }
    }
}
