package day0207;

import java.io.Serializable;

/**
 * 직렬화 방지 키워드 : transient
 */
public class UserData implements Serializable {	// Serializable을 구현 => 직렬화될 수 있다.
	/** 
	 * 객체를 식별할 수 있는 ID <br>
	 * serialVersionID가 바뀌면 읽어들일 수 없다.
	 */
	private static final long serialVersionUID = -5854305321529184079L;
	

	// 참조형 데이터형은 직렬화가 되지 않는다. 그러나 String class가 Serializable을 구현하고 있으므로 가능
	// Serializable와 transient를 함께 쓰면 transient가 우선한다.
	private /*transient*/ String name;
	private double height;	// 기본형 데이터형은 직렬화가 지원된다.
	private transient double weight;
	
	public UserData() {
		
	}	// UserData
	
	public UserData(String name, double height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}	// UserData

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

	@Override
	public String toString() {
		return super.toString();
	}
	
}	// class