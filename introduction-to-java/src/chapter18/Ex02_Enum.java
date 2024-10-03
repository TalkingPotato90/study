package chapter18;

enum Human2{MAN,WOMAN}
enum Machine2{TANK,AIRPLANE}
public class Ex02_Enum {
    public static void main(String[] args) {
        // 알맞은 상수 사용
        createUnit(Machine2.TANK);

        // 잘못된 상수 사용 : 에러
//        createUnit(Human2.MAN);

        // 참고 : C 언어처럼 숫자로 비교하면 에러가 난다.
//        if(Human2.MAN == 0){}
    }
    public static void createUnit(Machine2 kind){
        switch (kind){
            case TANK :
                System.out.println("탱크를 만듭니다.");
                break;
            case AIRPLANE:
                System.out.println("비행기를 만듭니다.");
                break;
        }
    }
}
