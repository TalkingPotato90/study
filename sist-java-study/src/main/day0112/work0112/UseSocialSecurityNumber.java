package day0112.work0112;

public class UseSocialSecurityNumber {

    public UseSocialSecurityNumber() {

    }

    public static void main(String[] args) {
        String ssn="950101-1234567";
        SocialSecurityNumber ssntest = new SocialSecurityNumber(ssn);
        ssntest.printPersonalInformation();

        ssntest.setSocialSecurityNumber("941224-569889");
        ssntest.printPersonalInformation();

    }
}
