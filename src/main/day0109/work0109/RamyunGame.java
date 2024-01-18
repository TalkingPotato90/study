package day0109.work0109;

public class RamyunGame {
    public static final int NEOGURI = 1;
    public static final int SHIN_RAMYUN = 2;
    public static final int ANSEONG_TANGMYEON = 3;

    private final String startMent = """
            라면 끓이기를 시작합니다.
            라면의 종류를 선택하세요
            
            1. 너구리    2. 신라면    3. 안성탕면
            """;
    private final String selectIngredientMent = """
            냄비에 넣을 재료를 고르세요.
            1. 분말수프    2. 면    3. 물    4. 건더기수프    5. 계란    6. 그만넣기 \
            """;
    private final String selectCookingTime = "조리 시간(분)을 선택하세요.";

    private int ramyunNum;
    private int ingredient;
    private int minute;

    public RamyunGame(int ramyunNum, int ingredient, int minute) {
        this.ramyunNum = ramyunNum;
        this.ingredient = ingredient;
        this.minute = minute;
    }

    public String selectRamyunMaker(int ramyunNum) {
        if (ramyunNum >= NEOGURI && ramyunNum <= ANSEONG_TANGMYEON) {
            switch (ramyunNum) {
                case NEOGURI:
                    return "너구리";
                case SHIN_RAMYUN:
                    return "신라면";
                case ANSEONG_TANGMYEON:
                    return "안성탕면";
                default:
                    return "라면선택 실패!!";
            }
        } else {
            return "라면선택 실패!!";
        }
    }

    public String addIngredient(int ingredient) {
        if (ingredient >= 1 && ingredient <= 5) {
            switch (ingredient) {
                case 1:
                    return "분말수프";
                case 2:
                    return "면";
                case 3:
                    return "물";
                case 4:
                    return "건더기수프";
                case 5:
                    return "계란";
                default:
                    return "재료 추가 실패";
            }
        } else {
            return (ingredient == 6 ? "재료 추가 중단" : "재료 추가 실패");
        }
    }


    public String cookingTime(int minute) {
        if (minute == 3) {
            return "알맞게 익었습니다";
        } else if (minute < 3) {
            return "많이 익었습니다";
        }
        return "덜 익었습니다";
    }

    public String getStartMent() {
        return startMent;
    }

    public int getRamyunNum() {
        return ramyunNum;
    }

    public void setRamyunNum(int ramyunNum) {
        this.ramyunNum = ramyunNum;
    }

    public int getIngredient() {
        return ingredient;
    }

    public void setIngredient(int ingredient) {
        this.ingredient = ingredient;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getSelectIngredientMent() {
        return selectIngredientMent;
    }

    public String getSelectCookingTime() {
        return selectCookingTime;
    }
}