package day0123.work0123;

public class WorkVO {

    private String studentName;
    private int javaScore;
    private int oracleScore;

    public WorkVO() {
    }

    public WorkVO(String studentName, int javaScore, int oracleScore) {
        this.studentName = studentName;
        this.javaScore = javaScore;
        this.oracleScore = oracleScore;
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
}
