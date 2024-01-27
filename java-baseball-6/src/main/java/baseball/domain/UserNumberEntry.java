package baseball.domain;

import baseball.validation.InputValidation;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserNumberEntry {
    public String inputUserNumber() {
        InputValidation inputValidation = new InputValidation();
        String userNum = Console.readLine();
        inputValidation.checkInputnumber(userNum);
        return userNum;
    }
    public List<Integer> userNumbers() {
        List<Integer> user = new ArrayList<>();
        String inputUser = inputUserNumber();

        for (char digit : inputUser.toCharArray()) {
            user.add(Character.getNumericValue(digit));
        }

        return user;
    }
}
