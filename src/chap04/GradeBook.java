package chap04;

class GradeBook {
    public void DisplayMessage(String courseName){
        // 인수의 내용 출력
        System.out.println("안녕하세요 책이름은 " + courseName + " 입니다!!");
        System.out.println();
    }
}

class GradeBookArg{
    public static void main(String[] args) {
        System.out.println("-->인수가 있는 객체의 생성 실습<--");
        String bookname;
        // 객체의 선언
        GradeBook myGradeBook = new GradeBook();
        bookname = "JAVA Programming";
        // 인수를 지정한 메소드의 호출
        myGradeBook.DisplayMessage(bookname);
    }
}


