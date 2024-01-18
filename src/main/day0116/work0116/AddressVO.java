package day0116.work0116;

public class AddressVO {
    private String name;
    private String address;
    private int age;

    public AddressVO(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }
}
