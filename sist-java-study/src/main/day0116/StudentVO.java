package day0116;

/**
 * 학생은 번호, 이름, 국어, 영어 를 가진다
 */
public class StudentVO {

    private int num;
    private String name;
    private int korScore;
    private int engScore;

    public StudentVO() {
    }

    public StudentVO(int num, String name, int korScore, int engScore) {
        this.num = num;
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
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

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }
}
