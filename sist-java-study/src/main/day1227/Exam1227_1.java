package day1227;

class Exam1227_1 {

    public static final int STANDARD_DAY = 20;
    public static final int MONTHLY_CASH = 500_000;

    public static void main(String[] args) {

        int onewayCost = 1750;
        int lunchCost = 5000;

        System.out.println("한달 용돈은 " + Exam1227_1.MONTHLY_CASH + "원 하루 용돈은 "
                + Exam1227_1.STANDARD_DAY + "일 기준으로 "
                + (Exam1227_1.MONTHLY_CASH / Exam1227_1.STANDARD_DAY)
                + "원 입니다.\n하루 지출은 편도 교통비" + onewayCost + "원 왕복 교통비 "
                + (onewayCost * 2) + "원 점심 식대 " + lunchCost + "원으로 총 "
                + ((onewayCost * 2) + lunchCost)
                + "원이 지출됩니다.\n\n한달이 지나면 잔액은 "
                + (Exam1227_1.MONTHLY_CASH - (((onewayCost * 2) + lunchCost) * Exam1227_1.STANDARD_DAY))
                + "원 입니다.");

        System.out.println("-------------------------------------------------");

        System.out.println("byte 최소값 " + Byte.MAX_VALUE + " 최대값 " + Byte.MIN_VALUE);
        System.out.println("double 최소값 " + Double.MAX_VALUE + " 최대값 " + Double.MIN_VALUE);
        System.out.println("float 최소값 " + Float.MAX_VALUE + " 최대값 " + Float.MIN_VALUE);
        System.out.println("int 최소값 " + Integer.MAX_VALUE + " 최대값 " + Integer.MIN_VALUE);
        System.out.println("long 최소값 " + Long.MAX_VALUE + " 최대값 " + Long.MIN_VALUE);
        System.out.println("short 최소값 " + Short.MAX_VALUE + " 최대값 " + Short.MIN_VALUE);

    } // main
} // class
