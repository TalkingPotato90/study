package day0110.work0110;

public class UseDog {
    public static void main(String[] args) {

        Dog smalldog = new Dog();
        smalldog.setSpecies("치와와");
        smalldog.setDogName("누렁이");
        System.out.println("태어난 강아지의 종은 " + smalldog.getSpecies() + "입니다.");

        System.out.println(smalldog.bark("멍"));
        System.out.println(smalldog.bark("지나가는 개","멍멍"));

    }
}
