package baseball;

import baseball.domain.ReadyForGame;
import baseball.domain.ResultDetermination;
import baseball.domain.UserNumberEntry;
import baseball.validation.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ReadyForGame readyForGame = new ReadyForGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ResultDetermination resultDetermination = new ResultDetermination();
        UserNumberEntry userNumberEntry = new UserNumberEntry();

        outputView.isBeginning();
        List<Integer> question = readyForGame.computerNumbers();

        while (true) {
            inputView.requestUserNumber();
            List<Integer> solution = userNumberEntry.userNumbers();

            String result = resultDetermination.calculateResult(question, solution);

            System.out.println(result);

            if (resultDetermination.flag == 'Y') {
                inputView.askGameRestart();
                String userSelect = Console.readLine();

                if (!userSelect.equals("1") && !userSelect.equals("2")) {
                    throw new IllegalArgumentException();
                }

                if (userSelect.equals("1")) {
                    resultDetermination.flag = 'N';
                    question = readyForGame.computerNumbers();
                    continue;
                }

                if (userSelect.equals("2")) {
                    break;
                }
            }
        }

    }




}