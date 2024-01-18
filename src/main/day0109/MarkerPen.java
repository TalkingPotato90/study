package day0109;

/**
 * 마카펜을 대상으로하여 추상화한 후 작성하는 클래스
 */
public class MarkerPen {
    private int cap;
    private int body;
    private String color;

    /**
     * 마카펜 객체의 칠판에 쓰는 일(동사적인 특징)을 구현
     *
     * @param msg 쓰고 싶은 메시지
     * @return 쓰는 일
     */
    public String write(String msg) {
        return "\"" + msg + "\"를 " + color + "색으로 칠판에 쓴다";
    }

    /**
     * 생성된 마카펜 객체 뚜껑의 개수를 설정하는 일<br>
     * 마카펜의 뚜껑은 1개만 설정된다
     *
     * @param cap 뚜껑의 개수
     */
    public void setCap(int cap) {
        // 원래 setter에서 validation을 하지는 않는다 => 수업용 예시
        if (cap != 1) {
            cap = 1;
        }
        this.cap = cap;
    }

    /**
     * 생성된 마카펜 객체 뚜껑의 개수를 반환하는 일
     *
     * @return 마카펜 객체의 뚜껑 개수
     */
    public int getCap() {
        return cap;
    }

    /**
     * 생성된 마카펜 객체의 몸체 개수를 설정하는 일
     *
     * @param body 설정할 몸체의 수
     */
    public void setBody(int body) {
        this.body = body;
    }

    /**
     * 생성된 마카펜 객체의 몸체 개수를 반환하는 일
     *
     * @return 몸체의 개수
     */
    public int getBody() {
        return body;
    }

    /**
     * 생성된 마카펜 객체의 색을 설정하는 일 <br>
     * 색은 "검은", "파란", "빨간" 만 설정할 수 있다<br>
     * 그 이외의 색이 입력되면 "검은" 색으로 instance variable를 설정
     *
     * @param color
     */
    public void setColor(String color) {
        if (!(color.equals("빨간") || color.equals("파란"))) {
            color = "검은";
        }
        this.color = color;
    }

    /**
     * 생성된 마카펜 객체의 색을 반환하는 일
     *
     * @return 설정된 색
     */
    public String getColor() {
        return color;
    }
}
