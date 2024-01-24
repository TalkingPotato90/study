package day0124.work0124;

public class WorkVO {
    private int studentNumber;
    private String studentName;
    private int javaScore;
    private int oracleScore;
    private int totalScore;
    private float averageScore;

    public WorkVO() {
    }

    public WorkVO(int number, String studentName, int javaScore, int oracleScore) {
        this.studentNumber = number;
        this.studentName = studentName;
        this.javaScore = javaScore;
        this.oracleScore = oracleScore;
        this.totalScore = javaScore + oracleScore;
        this.averageScore = totalScore / 2.0f;
    }

    public void printScore() {
        System.out.printf("%3d %6s  %5d  %5d   %5d  %.2f %n",
                studentNumber, studentName, javaScore, oracleScore, totalScore, averageScore);
    }

}
