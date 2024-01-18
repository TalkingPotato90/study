package day0110;

/**
 * 사람을 추상화하여 구현하는 클래스<br>
 * 명사적 특징 : 눈, 코, 입<br>
 * 동사적 특징 : 먹는 일<br>
 * <p>
 * 객체 생성을 하여 사용하는 일반 클래스<br>
 * 사용법 :<br>
 * Person 객체명 = new Person();<br>
 * 객체명.method()를 호출하여 사용
 */
public class Person {

    private int eyes, nose, mouth;
    private String name;
    public String nick;

    /**
     * 눈 2개, 코 1개, 입 1개인 사람 객체를 생성할 때 사용하는 기본 생성자
     */
    public Person() {
//        eyes = 1;
//        nose = 1;
//        mouth = 1;
        this(2,1,1);
    }

    /**
     * 눈 n개, 코 n개, 입 n개인 사람 객체를 생성할 때 사용하는 overloading된 생성자
     * @param eyes 눈의 개수
     * @param nose 코의 개수
     * @param mouth 입의 개수
     */
    public Person(int eyes, int nose, int mouth) {
        this.eyes = eyes;
        this.nose = nose;
        this.mouth = mouth;
    }

    /**
     * 생성된 사람객체의 눈의 개수를 설정하는 일
     *
     * @param eyes 설정할 눈의 개수
     */
    public void setEyes(int eyes) {
        this.eyes = eyes;
    }

    /**
     * 생성된 사람객체가 가지고 있는 눈의 개수를 반환하는 일
     *
     * @return 눈의 개수
     */
    public int getEyes() {
        return eyes;
    }

    /**
     * 생성된 사람객체의 코의 개수를 설정하는 일
     *
     * @param nose 설정할 코의 수
     */
    public void setNose(int nose) {
        this.nose = nose;
    }

    /**
     * 생성된 사람객체가 가지고 있는 눈의 개수를 반환하는 일
     *
     * @return 코의 개수
     */
    public int getNose() {
        return nose;
    }

    /**
     * 생성된 사람객체의 입의 개수를 설정하는 일
     *
     * @param mouth 설정할 입의 수
     */
    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    /**
     * 생성된 사람객체가 가지고 있는 입의 개수를 반환하는 일
     *
     * @return 입의 수
     */
    public int getMouth() {
        return mouth;
    }

    /**
     * 생성된 사람객체의 이름을 설정하는 일
     *
     * @param name 설정할 이름
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 생성된 사람객체가 가지고 있는 이름 반환하는 일
     *
     * @return 설정된 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 사람의 동사적인 특징 중 집에서 밥을 먹는 일을 구현한 method
     *
     * @return 밥을 먹는 행동
     */
    public String eat() {
        return name + "이(가) 집에서 밥을 먹는다.";
    }

    /**
     * 사람의 동사적인 특징 중 식당에서 밥을 사 먹는 일을 구현한 method
     *
     * @param menu  음식의 종류
     * @param price 음식의 가격
     * @return 밥을 먹는 행동
     */
    public String eat(String menu, int price) {
        return name + "이(가) 식당에서 메뉴 이름이 " + menu + "인 음식을 " + price + "원 내고 사 먹는다.";
    }
}
