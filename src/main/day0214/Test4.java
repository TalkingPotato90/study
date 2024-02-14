package day0214;

/**
 * @FunctionalInterface annotation이 정의되면 인터페이스는
 * abstract method를 하나만 가져야 한다.
 */
@FunctionalInterface
public interface Test4 {
	/**
	 * 반환형 있고 매개변수 있는 형
	 * @return
	 */
	public String temp(String s, int i);
}	// interface