package day0115;

public class SocialSecurityNumber {
    private String ssn;
    private String yearBirth;
    private String birthYear;
    private int numBirth;

    public SocialSecurityNumber(String ssn) {
        this.ssn = ssn;
    }//SocialSecurityNumber

    public boolean checkDigit() {
        return ssn.length() == 14;
    }//checkDigit

    public boolean checkDash() {
        return ssn.indexOf("-") == 6;
    }//checkDash

    public String birthDays() {
        String birthday = ssn.substring(0, 6);
        String birthYear = ssn.substring(0, 2);
        String year;
        if (ssn.charAt(7) == '1' || ssn.charAt(7) == '2' || ssn.charAt(7) == '5' || ssn.charAt(7) == '6') {
            year = "19";
            //19940728/ \\d{4}년\\d{2}월\\d{2}일 //$1년$2월$일
        } else if (ssn.charAt(7) == '3' || ssn.charAt(7) == '4' || ssn.charAt(7) == '7' || ssn.charAt(7) == '8') {
            year = "20";
        } else {
            year = "18";
        }
        yearBirth = year.concat(birthday);
        this.birthYear = year.concat(birthYear);
        numBirth = Integer.parseInt(this.birthYear);
        return yearBirth.replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1년$2월$3일");
    }//birthDays

    public int age() {
        return 2024 - numBirth + 1;
    }//age

    public String gender() {
        String result;
        if (ssn.charAt(7) == '1' || ssn.charAt(7) == '3' || ssn.charAt(7) == '5' || ssn.charAt(7) == '7' || ssn.charAt(7) == '9') {
            result = "남자";
        } else {
            result = "여자";
        }
        return result;
    }//gender

    //  7. 입력된 주민번호에서 띠를 구하여 문자열로 반환하는 method를 작성하세요.
    public String zodiac() {
        if (numBirth % 12 == 1) {
            return "닭띠";
        } else if (numBirth % 12 == 2) {
            return "개띠";
        } else if (numBirth % 12 == 3) {
            return "돼지 띠";
        } else if (numBirth % 12 == 4) {
            return "쥐 띠";
        } else if (numBirth % 12 == 5) {
            return "소 띠";
        } else if (numBirth % 12 == 6) {
            return "호랑이 띠";
        } else if (numBirth % 12 == 7) {
            return "토끼 띠";
        } else if (numBirth % 12 == 8) {
            return "용 띠";
        } else if (numBirth % 12 == 9) {
            return "뱀 띠";
        } else if (numBirth % 12 == 10) {
            return "말 띠";
        } else if (numBirth % 12 == 11) {
            return "양 띠";
        } else {
            return "원숭이 띠";
        }//if
    }//zodiac

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    public int getNumBirth() {
        return numBirth;
    }

    public void setNumBirth(int numBirth) {
        this.numBirth = numBirth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
}//end class