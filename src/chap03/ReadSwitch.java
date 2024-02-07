package chap03;

public class ReadSwitch {
    public static void main(String[] args) throws java.io.IOException {
        System.out.println("-->데이터를 입력받아 switch문 처리<--");
        int month;
        System.out.println("월을 입력하세요!!");
        month = System.in.read() - 48; // Ascii 코드 값 추출
        String season;

        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "겨울입니다!!";
                break;
            case 3:
            case 4:
            case 5:
                season = "봄입니다!!";
                break;
            case 6:
            case 7:
            case 8:
                season = "여름입니다!!";
                break;
            case 9:
            case 10:
            case 11:
                season = "가을입니다!!";
                break;
            default:
                season = "계절이 선택되지 않았습니다!!";
        }
        System.out.println(month + "월은" + season + "\n");
    }
}
