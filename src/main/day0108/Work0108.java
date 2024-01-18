package day0108;

public class Work0108 {

    public void printFullName(){
        System.out.println("홍길동");
    }

    public char printLastName(){
        return '홍';
    }

//    public String checkGrade(int score){
//        if (score < 0 || score > 100) {
//            return "잘못된 점수";
//        } else if (score >= 0 && score <= 39){
//            return "과락";
//        } else if(score >= 40 && score <= 59){
//            return  "다른 과목 참조";
//        }
//
//        return "합격";
//    }

    public void checkGrade(int score){
        if (score < 0 || score > 100) {
            System.out.println("잘못된 점수");
        } else if (score >= 0 && score <= 39){
            System.out.println("과락");
        } else if(score >= 40 && score <= 59){
            System.out.println("다른 과목 참조");
        }else System.out.println("합격");
    }

//    public String checkCharacterType(char character){
//        if(character>= 'A' && character <= 'Z'){
//            return "대문자";
//        } else if(character>='a' && character <= 'z'){
//            return "소문자";
//        } else if(character>= '0' && character<= '9') {
//            return "숫자";
//        }
//        return "대문자, 소문자, 숫자가 아닙니다.";
//    }
    public void checkCharacterType(char character){
        if(character>= 'A' && character <= 'Z'){
            System.out.println("대문자");
        } else if(character>='a' && character <= 'z'){
            System.out.println("소문자");
        } else if(character>= '0' && character<= '9') {
            System.out.println("숫자");
        } else System.out.println("대문자, 소문자, 숫자가 아닙니다.");
    }

    public int calculateAge(int birthYear){
        int thisYear = 2024;
        return thisYear - birthYear;
    }

    public int checkSmallestNumber(int num1, int num2, int num3){
//    return Math.min(num1,(Math.min(num2,num3)));
        if (num1 < num2 && num1 < num3){
            return num1;
        } else if(num2 < num1 && num2 < num3){
            return num2;
        }
        return num3;
    }

    public static void main(String[] args) {
        Work0108 work0108 = new Work0108();

    // 1. 자신의 이름을 출력하는 method
        work0108.printFullName();

    // 2. 자신의 이름 중에 성을 반환하는 method
        char lastName = work0108.printLastName();
        System.out.println(lastName);

    // 3. 점수를 입력받아 점수의 판정을 출력하는 method 작성
//        String grade = work0108.checkGrade(60);
//        System.out.println(grade);
        work0108.checkGrade(80);

    // 4. 문자를 입력방아 해당 문자가 "대문자", "소문자", "숫자" 인지를 판단하여 출력하는 method.
//        String characterType = work0108.checkCharacterType('s');
//        System.out.println(characterType);
        work0108.checkCharacterType('A');

    // 5. 태어난 해를 입력받아 나이를 반환하는 method
        int age = work0108.calculateAge(1990);
        System.out.println(age);

    // 6. 3개의 수를 입력받아 가장 "작은 수"를 반환하는 일을 하는 method
        int smallestNumber = work0108.checkSmallestNumber(1,3,0);
        System.out.println(smallestNumber);
    }

}
