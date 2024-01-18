package day0110.day0117.work0117;

public class Chihuahua extends Dog{
    @Override
    public String walk(String mate) {
        return getDogName() + "가 " + mate + "와 나란히 산책합니다.";
    }

    public static void main(String[] args) {
        Chihuahua c = new Chihuahua();
        c.setSpecies("치와와");
        c.setDogName("누렁이");
        System.out.println("태어난 강아지의 종은 " + c.getSpecies() + "입니다.");

        System.out.println(c.bark("멍"));
        System.out.println(c.bark("지나가는 개","멍멍"));
        System.out.println(c.walk("검둥이"));
    }
}
