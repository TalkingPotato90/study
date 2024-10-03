package day0125;

/**
 * 학생번호, 이름, 자바점수, 오라클 점수를 가짐
 */
public class WorkVO {
	/**
	 * 학생 번호
	 */
	private int num;
	/**
	 * 이름
	 */
	private String name;
	/**
	 * 자바점수
	 */
	private int scoreJava;
	/**
	 * 오라클 점수
	 */
	private int scoreOracle;

	/**
	 * 기본 생성자
	 */
	public WorkVO() {
	} // WorkVO

	/**
	 * 오버로드된 생성자
	 * @param name 이름
	 * @param scoreJava 자바점수
	 * @param scoreOracle 오라클 점수
	 */
	public WorkVO(int num, String name, int scoreJava, int scoreOracle) {
		this.num = num;
		this.name = name;
		this.scoreJava = scoreJava;
		this.scoreOracle = scoreOracle;
	} // WorkVO

	/**
	 * 이름을 얻는 일을 하는 getter method
	 * @return 이름
	 */
	public String getName() {
		return name;
	} //getName

	/**
	 * 이름을 설정하는 일을 하는 setter method
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	} // setName

	/**
	 * 자바 점수를 얻는 일을 하는 getter method
	 * @return 자바점수
	 */
	public int getScoreJava() {
		return scoreJava;
	} // getScoreJava

	/**
	 * 자바 점수를 설정하는 일을 하는 setter method
	 * @param scoreJava 자바 점수
	 */
	public void setScoreJava(int scoreJava) {
		this.scoreJava = scoreJava;
	} // setScoreJava

	/**
	 * 오라클 점수를 얻는 일을 하는 getter method
	 * @return 오라클 점수
	 */
	public int getScoreOracle() {
		return scoreOracle;
	} // getScoreOracle

	/**
	 * 오라클 점수를 설정하는 일을 하는 setter method
	 * @param scoreOracle 오라클 점수
	 */
	public void setScoreOracle(int scoreOracle) {
		this.scoreOracle = scoreOracle;
	} // setScoreOracle

	/**
	 * 학생 번호를 얻는 일을 하는 getter method
	 * @return 학생 번호
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 학생 번호를 설정하는 일을 하는 setter method
	 * @param num 학생 번호
	 */
	public void setNum(int num) {
		this.num = num;
	}

}