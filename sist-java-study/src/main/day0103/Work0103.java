package day0103;

public class Work0103 {
    public static final int BASIC_VILLAGE_BUS = 1200;
    public static final int BASIC_BUS = 1500;
    public static final int BASIC_METRO = 1400;

    public static final int BASIC_DISTANCE = 10;
    public static final int BASIC_Monthday = 20;
    public static final int UNIT_DISTANCE = 5;
    public static final int UNIT_FEE = 100;


    public static void main(String[] args) {
        int basicFee = 0;
        int distance = Integer.parseInt(args[1]);
        int excessDistance = distance - BASIC_DISTANCE;
        int excessFee = 0;

        if ((distance > BASIC_DISTANCE) && (excessDistance % UNIT_DISTANCE == 0)) {
            excessFee = (excessDistance / UNIT_DISTANCE) * UNIT_FEE;
        } else if ((distance > BASIC_DISTANCE) && (excessDistance % UNIT_DISTANCE != 0)) {
            excessFee = ((excessDistance / UNIT_DISTANCE) + 1) * UNIT_FEE;
        }

        basicFee = switch (args[0]) {
            case "마을버스" -> BASIC_VILLAGE_BUS;
            case "버스" -> BASIC_BUS;
            case "지하철" -> BASIC_METRO;
            default -> basicFee;
        };

        int onewayFee = basicFee + excessFee;
        int roundTripFee = onewayFee * 2;
        int monthlyFee = roundTripFee * BASIC_Monthday;

        if (args[0].equals("마을버스") || args[0].equals("버스") || args[0].equals("지하철")) {
            System.out.println("입력하신 교통수단은 " + args[0] + "이고, 이동거리는 " + distance + "Km 입니다.\n" +
                    "교통수단의 기본요금 : " + basicFee + "원,\n" +
                    "편도요금 : " + onewayFee + "원\n" +
                    "왕복요금 : " + roundTripFee + "원\n" +
                    "한달 20일 기준 총 교통 요금은 " + monthlyFee + "원 입니다.");
        } else {
            System.out.println("대중교통 수단이 아닙니다.");
        }
    }
}
