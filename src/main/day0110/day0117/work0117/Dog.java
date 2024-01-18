package day0110.day0117.work0117;

public abstract class Dog {
    public static final int NORMAL_EYES = 2;
    public static final int NORMAL_NOSE = 1;
    public static final int NORMAL_EARS = 2;
    public static final int NORMAL_MOUTH = 1;
    private int eye;
    private int nose;
    private int ear;
    private int mouth;
    private String species;
    private String dogName;


    public Dog() {
        eye = NORMAL_EYES;
        nose = NORMAL_NOSE;
        ear = NORMAL_EARS;
        mouth = NORMAL_MOUTH;
        System.out.println("눈, 코, 입이 평범한 강아지가 태어났습니다.");
    }

    public Dog(int eye, int nose, int ear, int mouth) {
        this.eye = eye;
        this.nose = nose;
        this.ear = ear;
        this.mouth = mouth;
        System.out.println("눈, 코, 입이 범상치 않은 강아지가 태어났습니다.");
    }

    public String bark(String bark) {
        return species + "인 " + dogName + "가 " + bark + "하고 짖는다";
    }

    public String bark(String someone, String bark) {
        return someone + "을 향해서 " + bark + "하고 짖는다";
    }

    public abstract String walk(String mate);

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}
