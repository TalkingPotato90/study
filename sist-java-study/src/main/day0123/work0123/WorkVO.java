package day0123.work0123;

public class WorkVO {
    private static int studentNumber = 1;
    private int number;
    private String studentName;
    private int javaScore;
    private int oracleScore;

    public WorkVO() {
    }

    public WorkVO(String studentName, int javaScore, int oracleScore) {
        this.studentName = studentName;
        this.javaScore = javaScore;
        this.oracleScore = oracleScore;
        this.number = studentNumber++;
    }

    public void printScore() {
        System.out.printf("%3d %6s  %5d  %5d   %5d%n",
                number, studentName, javaScore, oracleScore, javaScore + oracleScore);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(int javaScore) {
        this.javaScore = javaScore;
    }

    public int getOracleScore() {
        return oracleScore;
    }

    public void setOracleScore(int oracleScore) {
        this.oracleScore = oracleScore;
    }

//    @Override
//    public String toString() {
//        return  studentName + "\t" + javaScore + "\t\t" + oracleScore;
//    }
}
