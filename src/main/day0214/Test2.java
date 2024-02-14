package day0214;

/**
 * @FunctionalInterface annotation이 정의되면 인터페이스는
 * abstract method를 하나만 가져야 한다.
 */
@FunctionalInterface
public interface Test2 {
	/**
	 * 반환형 없고, 매개변수 있는 형
	 * @param i
	 * @param s
	 */
	public void temp(int i, String s);
}	// interface