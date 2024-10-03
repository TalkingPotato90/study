package day0110.day0117.work0117;

public class Malamute extends Dog{
    @Override
    public String walk(String mate) {

        return getDogName()+"가 " + mate + "를 질질 끌고 갑니다.";
    }

    public static void main(String[] args) {
        Malamute m = new Malamute();
        m.setSpecies("말라뮤트");
        m.setDogName("흰둥이");
        System.out.println("태어난 강아지의 종은 " + m.getSpecies() + "입니다.");

        System.out.println(m.bark("왕"));
        System.out.println(m.bark("도망가는 개","왕왕"));
        System.out.println(m.walk("누렁이"));
    }

}
