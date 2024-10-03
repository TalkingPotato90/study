package day0305.homework_ljh.vo;

import java.sql.Date;

public class StudentVO {
	
	private int num, age, studentNum;
	private String name, img_name;
	private Date input_date;
	
	public StudentVO() {
	}
	
	public StudentVO(int age, String name, String img_name, Date input_date) {
		this.age = age;
		this.name = name;
		this.img_name = img_name;
		this.input_date = input_date;
	}
	
	public StudentVO(int age, String name, String img_name, Date input_date, int studentNum) {
		this.age = age;
		this.name = name;
		this.img_name = img_name;
		this.input_date = input_date;
		this.studentNum = studentNum;
	}

	public StudentVO(int num, int age, String name, String img_name, Date input_date, int studentNum) {
		this.num = num;
		this.age = age;
		this.name = name;
		this.img_name = img_name;
		this.input_date = input_date;
		this.studentNum = studentNum;
	}
	
	public int getNum() {
		return num;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getImg_name() {
		return img_name;
	}

	public Date getInput_date() {
		return input_date;
	}

	public int getStudentNum() {
		return studentNum;
	}

	@Override
	public String toString() {
		return "age=" + age + ", name=" + name + ", img_name=" + img_name + ", input_date="
				+ input_date + "]";
	}	

}	// class