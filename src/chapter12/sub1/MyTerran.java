package chapter12.sub1;
// 부모 클래스
class Unit{
    String name;
    int hp;

    void printUnit(){
        System.out.println("이름 : " + name);
        System.out.println("HP : " + hp);
    }
}

// Unit을 상속한 자식 클래스
// 멤버를 그대로 계승하여 name, hp, attack 사용 가능
// printUnit(), printMarine() tkdyd rksmd
class Marine extends Unit {
    int attack;

    void printMarine(){
        // 상속받은 printUnit() 호출
        printUnit();
        System.out.println("공격력 : " + attack);
    }
}

// 자식 클래스
class Medic extends Unit {
    // 멤버 변수
    int heal;

    void printMedic(){
        printUnit();
        System.out.println("치유량 : " + heal);
    }
}

public class MyTerran {
    public static void main(String[] args) {
        Marine unit1 = new Marine();
        unit1.name = "마린";
        unit1.hp = 100;
        unit1.attack = 20;

        Medic unit2 = new Medic();
        unit2.name = "메딕";
        unit2.hp = 120;
        unit2.heal = 10;

        unit1.printMarine();
        System.out.println();
        unit2.printMedic();
    }
}
