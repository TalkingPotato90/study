package day0110.day0117;

import day0116.work0116.Potato;

/**
 * Person 클래스의 자식클래스를 사용하기 위해서 만드는 클래스<br>
 */
public class UsePerson {

    private void usePerson() {
        HongGilDong hgd = new HongGilDong();
        // 코드의 재사용성 : 부모클래스의 method, 변수를 내 클래스에 존재하는 것처럼 사용
        hgd.setName("홍길동");
        System.out.printf("눈 %d, 코 %d, 입 %d, 이름 %s\n",
                hgd.getEyes(), hgd.getNose(), hgd.getMouth(), hgd.getName());

        System.out.println(hgd.fight(5)); // 6 -> 7
        System.out.println(hgd.fight(6)); // 7 -> 8
        System.out.println(hgd.fight(8)); // 7 -> 8
        System.out.println(hgd.fight(9)); // 8 -> 7
        System.out.println(hgd.getLevel()); // 7

        System.out.println("------------------------------------------------------------------");
        Clark superman = new Clark();
        // 코드의 재사용성 : 부모클래스의 method, 변수를 내 클래스에 존재하는 것처럼 사용
        superman.setName("클락 켄트");
        System.out.printf("눈 %d, 코 %d, 입 %d, 이름 %s\n",
                superman.getEyes(), superman.getNose(), superman.getMouth(), superman.getName());

        System.out.println(superman.power("다이아몬드"));
        System.out.println(superman.power("크립토나이트"));
        System.out.println(superman.power("짱돌"));
        System.out.println(superman.power);

        System.out.println("------------------------------------------------------------------");
        Potato p = new Potato();
        // 코드의 재사용성 : 부모클래스의 method, 변수를 내 클래스에 존재하는 것처럼 사용
        p.setName("감자");
        System.out.printf("눈 %d, 코 %d, 입 %d, 이름 %s\n",
                p.getEyes(), p.getNose(), p.getMouth(), p.getName());

        System.out.println(p.mineGame());
        System.out.println(p.mineGame());
        System.out.println(p.mineGame());
        System.out.println(p.mineGame());
        System.out.println(p.getMinesweeperLevel());

        System.out.println("------------------------------------------------------------------");

        // 코드의 재사용성 : 부모클래스에 존재하는 변수나 method를 자식클래스에서
        // 자식의 객체명으로 사용하는 것 -> 부모에서 제공하는 기능이 자식과 맞지 않는 상황발생!!
        System.out.println(hgd.eat());
        System.out.println(superman.eat());
        System.out.println(hgd.eat("뜨끈한 국밥", 3));
        System.out.println(superman.eat("스테이크", 10));

        System.out.println(hgd);
        System.out.println(superman);

        System.out.println(hgd.eat());

        System.out.println("------------------------------------------------------------------");

        System.out.println("추력 : " + superman.thrust());
        System.out.println("양력 : " + superman.lift());
    }

    public static void main(String[] args) {
        UsePerson up = new UsePerson();
        up.usePerson();
    }
}
