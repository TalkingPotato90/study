package day0112.work0112;

import day0103.Zodiac;

public class SocialSecurityNumber {
    public static final int CURRENT_YEAR = 2024;
    public static final int ZODIAC_UNIT = 12;
    private String socialSecurityNumber;
    private String[] ssnArray;
    private String genderAndBirthyearIndex;
    private int birthYearInt;

    public SocialSecurityNumber(String inputNum) {
        this.socialSecurityNumber = inputNum;
        this.ssnArray = convertToCharArray();
        this.genderAndBirthyearIndex = ssnArray[7];
        validateInputFormat();
    }

    public int ssnArrayLength() {
        return ssnArray.length;
    }

    public boolean lengthCheck() {
        return ssnArrayLength() == 14;
    }

    public boolean check7thIndex() {
        return getSsnArray()[6].equals("-");
    }

    public void validateInputFormat() {
        if (!lengthCheck() && !check7thIndex()) {
            System.out.println("주민번호의 자릿수와 -의 위치가 올바르지 않음");
        } else if (!lengthCheck()) {
            System.out.println("주민번호의 자릿수가 잘못되었음");
        } else if (!check7thIndex()) {
            System.out.println("-의 위치가 올바르지 않음");
        }
    }

    public String[] convertToCharArray() {
        String[] ssnArray = new String[socialSecurityNumber.length()];
        for (int i = 0; i < socialSecurityNumber.length(); i++) {
            ssnArray[i] = String.valueOf(socialSecurityNumber.charAt(i));
        }
        return ssnArray;
    }

    public String checkBirthYear() {
        String birthYear;
        if (genderAndBirthyearIndex.equals("1") || genderAndBirthyearIndex.equals("2") || genderAndBirthyearIndex.equals("5") || genderAndBirthyearIndex.equals("6")) {
            birthYear = "19" + ssnArray[0] + ssnArray[1];
        } else if (genderAndBirthyearIndex.equals("3") || genderAndBirthyearIndex.equals("4") || genderAndBirthyearIndex.equals("7") || genderAndBirthyearIndex.equals("8")) {
            birthYear = "20" + ssnArray[0] + ssnArray[1];
        } else {
            birthYear = "18" + ssnArray[0] + ssnArray[1];
        }
        return birthYear;
    }

    public String printBirthYear() {
        String birthMonth = ssnArray[2] + ssnArray[3];
        String birthDay = ssnArray[4] + ssnArray[5];
        return checkBirthYear() + "년 " + birthMonth + "월 " + birthDay + "일";
    }

    public int calculateAge() {
        this.birthYearInt = Integer.parseInt(checkBirthYear());
        return CURRENT_YEAR - this.birthYearInt;
    }

    public String checkGender() {
        int digit7Value = Integer.parseInt(this.genderAndBirthyearIndex);
        if (digit7Value % 2 != 0) {
            return "남자";
        } else {
            return "여자";
        }
    }

    public String checkZodiac() {
        int zodiacIndex = this.birthYearInt % ZODIAC_UNIT;

        return switch (zodiacIndex) {
            case Zodiac.MONKEY -> "원숭이";
            case Zodiac.ROOSTER -> "닭";
            case Zodiac.DOG -> "개";
            case Zodiac.PIG -> "돼지";
            case Zodiac.RAT -> "쥐";
            case Zodiac.OX -> "소";
            case Zodiac.TIGER -> "호랑이";
            case Zodiac.RABBIT -> "토끼";
            case Zodiac.DRAGON -> "용";
            case Zodiac.SNAKE -> "뱀";
            case Zodiac.HORSE -> "말";
            default -> "양";
        };
    }

    public void printPersonalInformation() {
        if (lengthCheck() && check7thIndex()) {
            System.out.println(printBirthYear());
            System.out.println(calculateAge() + "살");
            System.out.println(checkGender());
            System.out.println(checkZodiac());
        } else {
            System.out.println("올바르지 않은 입력으로 정보 확인 불가");
        }
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.ssnArray = convertToCharArray();
        this.genderAndBirthyearIndex = ssnArray[7];
        validateInputFormat();
    }

    public String[] getSsnArray() {
        return ssnArray;
    }

    public String getGenderAndBirthyearIndex() {
        return genderAndBirthyearIndex;
    }

    public int getBirthYearInt() {
        return birthYearInt;
    }

    public void setBirthYearInt(int birthYearInt) {
        this.birthYearInt = birthYearInt;
    }
}
