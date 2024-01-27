package baseball.domain;

import java.util.List;

public class ResultDetermination {
    public char flag = 'N';
    public String calculateResult(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i))) {
                strike++;
            } else if (computerNumbers.contains(userNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            flag = 'Y';
            return "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        String nothing = (strike == 0 && ball == 0) ? "낫싱" : "";
        return (ball > 0 ? ball + "볼 " : "") + (strike > 0 ? strike + "스트라이크" : "") + nothing;
    }
}
