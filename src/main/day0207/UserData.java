package day0207;

import java.io.Serializable;

/**
 * 직렬화 방지 키워드 : transient
 */
public class UserData implements Serializable {

    private transient String name; //참조형 데이터형은 직렬화가 되지 않음.
    private double height; //기본형 데이터형은 직렬화가 지원된다.
    private transient double weight;

    public UserData() {

    }//생성자

    public UserData(String name, double height, double weight) {
        super();
        this.name = name;
        this.height = height;
        this.weight = weight;
    }//생성자

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
        return "UserData [name=" + name + ", height=" + height + ", weight=" + weight + "]";
    }

}//class