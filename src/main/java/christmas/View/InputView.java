package christmas.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputDate() {
        while (true) {
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                String date = Console.readLine();
                int visitDate = Integer.parseInt(date);

                if (1 <= visitDate && visitDate <= 31) {
                    return visitDate;
                }
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
    }
}