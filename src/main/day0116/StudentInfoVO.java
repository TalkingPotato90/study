package day0116;

/**
 * 사용자 정의 자료형 - 순수하게 값만 저장하기 위해서 만든다<br>
 * 클래스명 뒤에 VO(Value Object)를 붙여준다<br>
 * (분할된 여러 값들을 묶어서 저장할 수 있다)<br>
 * 학생은 학번, 이름, 나이, 키, 몸무게, 이메일의 정보가 저장되어야한다
 */
public class StudentInfoVO {
    private int num;
    private String name;
    private double height;
    private double weight;
    private String email;

    /**
     * 기본생성자 - 인스턴스 변수에 default value값이 할당되어 객체가 생성된다
     * 인스턴스 변수에 값 변경은 setter method를 사용하여 변경한다
     */
    public StudentInfoVO() {
    }

    /**
     * Overload된 생성자.<br>
     * 객체를 생성할 때 default value가 아닌 사용자가 원하는 값으로
     * 설정한 후 객체를 생성하는 생성자
     * @param num 학생의 번호
     * @param name 이름
     * @param height 키
     * @param weight 몸무게
     * @param email 이메일
     */
    public StudentInfoVO(int num, String name, double height, double weight, String email) {
        this.num = num;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.email = email;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
